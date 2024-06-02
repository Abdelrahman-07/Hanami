package com.example.flowerimageclassifier


import android.media.Image
// data class that stores the disease data
data class DiseaseData(val name:String, val description:String, val treatment:String, val image: Image )

// disease names
val disease_names = arrayOf(
    "Powdery Mildew",
    "Grey Mold",
    "Black spot",
    "Botrytis",
    "Root Rot",
    "Leaf Rust",
    "Fire Blight",
    "Verticillium Wilt",
    "Sooty"

)
// disease description
val disease_description = arrayOf(
    "Powdery mildew appears as a white, powdery covering the leaf surfaces, as the name implies. The term refers to a group of closely related fungal species that affect one or even more plants. As a result, the powdery mildew on your lavender might not be the same as the one that’s wreaking havoc on your rose flower.\nIf the infection is severe, it may appear on stems and even the flowers themselves. Leaves that have been affected end up turning yellowish, then brown.\n\n",

    "Grey mold is one of the most common flower diseases. It’s especially troublesome when there’s a lot of rain and it’s cold outside. Gray mold, like powdery mildew, has a catchy name. It manifests itself as a grey mold on old and dying leaves and flowers. It starts as water-soaked spots and progresses to a grey, fuzzy coat.\n\n",

    "This is a fungal infection that affects roses, as well as other flowers and fruits. While it does not kill plants, it makes them weak and more vulnerable to other issues. Some black spots appear on the foliage during the cold season, causing the leaves to turn yellow and then fall off.\n\n",

    "This fungal disease starts as fluffy, grey growth on flowers and quickly spreads to the stems, causing plants to become weak and cracked. Botrytis blight is typically controlled through better growing conditions and hygiene. Causes damage in flowers such as Rosa, Gerbera, chrysanthemum, and Lisianthus\n\n",

    "This soil-borne fungus stunts growth and causes wilting to leaves. Affected plant roots frequently have a wet, foul odor and a rotten appearance. Some plants may have black strands.\n\n",

    "Leaf rust is an infection that damages flowering plants. It is frequently found on roses, hollyhocks, snapdragons, and daylilies. Rust diseases cause raised blisters on the undersurface of affected leaves, which rupture to release milky, bright yellow to red spores.\n The infection does not kill the plant completely, but weakens over time, making it more vulnerable to other diseases and winter damages.\n\n",

    "This bacterial infection typically affects flowering plants, causing brown and withered flowers to appear first, followed by brown or black leaves. Cankers may appear on branches. The disease, mostly during rainy seasons, usually begins on the plant’s top section then under the leaf surface.\n\n",

    "This fungal disease causes wilting, as well as yellowing and drooping leaves. It usually appears first on the outer leaves. The Yellow patches turn brown and cover entire leaves, causing the plant to die.\n",

    "Plants with sooty mold have flecked stems and leaves. It has a black layer that you can easily wipe away with your fingers. The mold is drawn to the sweet “honeydew” that aphids and other sucking insects leave behind.\n"
)
// disease treatment
val disease_treatment = arrayOf(
    "If only a few leaves are affected, pluck them off and discard them. \nUse baking soda as a home remedy:\n Mix one tablespoon of warm water and baking soda; spray every seven to ten days on plants.",

    "Remove and destroy the infected plants so that the disease doesn’t spread to your other plants. Also, you can use sprays with bacteria controls on your flower plants to treat the infections.",

    "Prune the affected plants and dispose of them. You can also use a natural solution such as distilled vinegar to remove the black spot. You can also use neem oil to prevent black mold.",

    "Use recommended fungicides for treating botrytis. Make sure to remove any dead substance from the plant before the fall.",

    "Remove the plant from its container and separate the soil from the root ball. Remove rotting roots with disinfected scissors. To kill any bacteria, clean the pot with a hydrogen peroxide water solution. Apply fungicides early enough.",

    "Destroy diseased plants to stop the further spread and to make sure the area is clean. A fungicide approved for use against rust may be beneficial.",

    "There is no remedy for fire blight; the best fire blight treatments are regular trimming and removing any diseased stems and branches. Also,   avoid overhead watering because if you splash water over the plant, you create room for the spread of this infection. \nTakedown and destroy any affected branches. Use the recommended fungicides.",

    "Verticillium wilt has no treatment. Destroy diseased plants and refrain from planting those flower plants in that area for at least three years.",

    "Wiping affected parts with water can sometimes be sufficient to remove the sooty fungal growth. Avoid strong detergents in the water because they can scorch the foliage.\n Lukewarm water is more effective in sooty treatment."
)
//disease images
val disease_image = arrayOf(
    R.drawable.powdery_mildew,
    R.drawable.gray_mold,
    R.drawable.blackspot,
    R.drawable.botrytis,
    R.drawable.root_rot,
    R.drawable.leaf_rust,
    R.drawable.fire_blight,
    R.drawable.verticillium_wilt,
    R.drawable.sooty

)