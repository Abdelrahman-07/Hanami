package com.example.flowerimageclassifier
// list of imports
import android.Manifest
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity

import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.ui.text.toLowerCase
import com.example.flowerimageclassifier.ml.FlowerModelFinalQuantized
import org.tensorflow.lite.support.image.TensorImage
import java.io.FileDescriptor
import hotchemi.android.rate.AppRate
// activity for the classifier
class ClassifierActivity : ComponentActivity() {

    // declare variables
    lateinit var bitmap:Bitmap
    lateinit var selectbtn:Button
    lateinit var camerabtn:Button
    lateinit var predictbtn:Button
    lateinit var resultView:TextView
    lateinit var resultHeader:TextView
    lateinit var toxicityHeader:TextView
    lateinit var toxicityBody:TextView
    lateinit var cultHeader:TextView
    lateinit var cultBody:TextView
    lateinit var image:ImageView
    var image_uri: Uri? = null

    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // set the layout of the page
        setContentView(R.layout.activity_classifier)
        // rate us popup
        AppRate.with(this)
            // monitor install days
            .setInstallDays(0)
            // monitor launch time
            .setLaunchTimes(3)

            // set remind period
            .setRemindInterval(1)
            .monitor()

        // Show a dialogue if meets conditions
        AppRate.showRateDialogIfMeetsConditions(this)
        // setup the image uri to pass to the camera intent
        val values = ContentValues()
        values.put(MediaStore.Images.Media.TITLE, "New Picture")
        values.put(MediaStore.Images.Media.DESCRIPTION, "From the Camera")
        image_uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri)
        // setup galley intent
        var galleryIntent = Intent(Intent.ACTION_GET_CONTENT)
        galleryIntent.setType("image/*")

        // initialize the variables
        selectbtn = findViewById(R.id.selectbtn)
        image = findViewById(R.id.imageview)
        camerabtn = findViewById(R.id.camera)
        predictbtn = findViewById(R.id.predict)
        resultView = findViewById(R.id.result_view)
        resultHeader = findViewById(R.id.result_header_view)
        toxicityHeader = findViewById(R.id.toxic_header_view)
        toxicityBody =  findViewById(R.id.toxic_body_view)
        cultHeader = findViewById(R.id.cult_header_view)
        cultBody = findViewById(R.id.cult_body_view)


        // make a toast when the upload  image placeholder
        image.setOnClickListener {
            Toast.makeText(this,"Upload a photo by pressing the gallery or camera button.", Toast.LENGTH_SHORT).show()
        }
        // open the gallery when the button is clicked
        selectbtn.setOnClickListener {
            // use the new image picker if the device runs android 13 or later
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                // request media access from the user
                if (checkSelfPermission(Manifest.permission.READ_MEDIA_IMAGES) == PackageManager.PERMISSION_GRANTED) {

                    galleryIntent = Intent(Intent.ACTION_GET_CONTENT)
                    galleryIntent.setType("image/*")

                    // launch the gallery
                    getGalleryImage.launch(galleryIntent)


                } else {
                    requestPermissions(
                        arrayOf(
                            Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED,
                            Manifest.permission.READ_MEDIA_IMAGES
                        ), 100
                    )
                }

            // use the old image picker if the device runs android 12 or earlier
            }else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.TIRAMISU) {
                // request media access from the user
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                galleryIntent = Intent(Intent.ACTION_PICK)
                galleryIntent.setType("image/*")

                // launch the gallery
                getGalleryImage.launch(galleryIntent)
            } else {
                requestPermissions(
                    arrayOf(
                        Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                    ), 100
                )
            }
        }

        }
        //  open the camera when the button is pressed
        camerabtn.setOnClickListener {
            // ask the user for camera permission
            if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                // launch the camera
                getPreviewImage.launch(cameraIntent)
            } else {
                requestPermissions(arrayOf(Manifest.permission.CAMERA), 100)
            }

        }

        // predict the flower type
        predictbtn.setOnClickListener {

            // only predict when an image is uploaded.
            if(image.drawable!= null)
            {
                // initialize the model
                // this is the quantized version of the model
                val model = FlowerModelFinalQuantized.newInstance(this)
                val image = TensorImage.fromBitmap(bitmap)
                // Runs model inference and gets result.
                val outputs = model.process(image)
                //sort the outputs and get the model output
                val score = outputs.scoreAsCategoryList.apply {
                    sortByDescending { it.score }
                }[0].label

                val confidence = outputs.scoreAsCategoryList.apply {
                    sortByDescending { it.score }
                }[0].score
                // display the flower type, growing methods, and toxicity
                var index = flower_names_lower.indexOf(score.toString())

                if (confidence<0.25)
                {
                    resultView.text = getString(R.string.low_accuracy_msg)
                    resultHeader.text = getString(R.string.blank)
                    cultBody.text = getString(R.string.blank)
                    cultHeader.text = getString(R.string.blank)
                    toxicityHeader.text = getString(R.string.blank)
                    toxicityBody.text = getString(R.string.blank)
                }
                else
                {
                    resultHeader.text = getString(R.string.result_header)
                    resultView.text = flower_names[index]
                    cultBody.text = cult_methods[index]
                    cultHeader.text = getString(R.string.cult_header)
                    toxicityHeader.text = getString(R.string.toxic_header)

                    if(flower_toxicity[index])
                    {
                        toxicityBody.text = getString(R.string.toxic_body_pos)
                    }
                    else
                    {
                        toxicityBody.text = getString(R.string.toxic_body_neg)
                    }
                }



                // Releases model resources if no longer used.
                model.close()
            }
            else
            {
                Toast.makeText(this,"Please select a photo first", Toast.LENGTH_SHORT).show()


            }





        }






    }

    // function to display the image the user captured
    private val getPreviewImage =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == RESULT_OK){
                image.setImageURI(image_uri)
                // convert the image to bitmap to feed into the classifier
                bitmap= uriToBitmap(image_uri)
                image.setImageBitmap(bitmap)



            }
        }
    // function to display the image the user picked
    private val getGalleryImage =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                var uri  = it.data?.data
                // convert the image to bitmap to feed into the classifier
                bitmap = MediaStore.Images.Media.getBitmap(this.contentResolver, uri)
                image.setImageBitmap(bitmap)
            }
        }

    //function to get image bitmap from uri
    private fun uriToBitmap(selectedFileUri: Uri?): Bitmap {

        val parcelFileDescriptor =
            selectedFileUri?.let { contentResolver.openFileDescriptor(it, "r") }
        val fileDescriptor: FileDescriptor = parcelFileDescriptor!!.fileDescriptor
        val image = BitmapFactory.decodeFileDescriptor(fileDescriptor)
        parcelFileDescriptor.close()
        return image

    }
}







