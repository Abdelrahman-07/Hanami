package com.example.flowerimageclassifier

import android.media.Image
// data class that stores flower data
data class FlowerData(val id: Int, val name: String, val link:String, val cultMethod:String, val toxic:Boolean, val flowerImage: Image)

// flower ids
val flower_ids = arrayOf(
    1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
    21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
    41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60,
    61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80,
    81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102
)
//flower names
val flower_names = arrayOf(
    "Pink Primrose","Hard-leaved Pocket Orchid","Canterbury Bells","Sweet Pea","English Marigold"
    ,"Tiger Lily","Moon Orchid","Bird of Paradise","Monkshood","Globe Thistle","Snapdragon"
    ,"Colt's Foot","King Protea","Spear Thistle","Yellow Iris","Globe Flower","Purple Coneflower"
    ,"Peruvian Lily","Balloon Flower","Giant White Arum Lily","Fire Lily","Pincushion Flower"
    ,"Fritillary","Red Ginger","Grape Hyacinth","Corn Poppy","Prince of Wales Feathers","Stemless Gentian","Artichoke"
    ,"Sweet William","Carnation","Garden Phlox","Love In The Mist","Mexican Aster","Alpine Sea Holly","Ruby-lipped Cattleya"
    ,"Cape Flower","Great Masterwort","Siam Tulip","Lenten Rose","Barbeton Daisy","Daffodil"
    ,"Sword Lily","Poinsettia","Bolero Deep Blue","Wallflower","Marigold","Buttercup","Oxeye Daisy"
    ,"Common Dandelion","Petunia","Wild Pansy","Primula","Sunflower","Pelargonium","Bishop of Llandaff"
    ,"Gaura","Geranium","Orange Dahlia","Pink-Yellow Dahlia","Cautleya Spicata","Japanese Anemone"
    ,"Black-eyed Susan","Silverbush","Californian Poppy","Osteospermum","Spring Crocus","Bearded Iris"
    ,"Windflower","Tree Poppy","Gazania","Azalea","Water lLily","Rose","Thorn apple"
    ,"Morning Glory","Passion Flower","Lotus","Toad Lily","Anthurium","Frangipani","Clematis"
    ,"Hibiscus","Columbine","Desert Rose","Tree Mallow","Magnolia","Cyclamen","Watercress"
    ,"Canna Lily","Hippeastrum","Bee Balm","Pink Quill","Foxglove","Bougainvillea","Camellia"
    ,"Mallow","Mexican Petunia","Bromelia","Blanket Flower","Trumpet Creeper","Blackberry Lily"
)

// classifier labels
val flower_names_lower = arrayOf(
    "pink primrose","hard-leaved pocket orchid","canterbury bells","sweet pea","english marigold"
    ,"tiger lily","moon orchid","bird of paradise","monkshood","globe thistle","snapdragon"
    ,"colt's foot","king protea","spear thistle","yellow iris","globe flower","purple coneflower"
    ,"peruvian lily","balloon flower","giant white arum lily","fire lily","pincushion flower"
    ,"fritillary","red ginger","grape hyacinth","corn poppy","prince of wales feathers","stemless gentian","artichoke"
    ,"sweet william","carnation","garden phlox","love in the mist","mexican aster","alpine sea Holly","ruby-lipped cattleya"
    ,"cape flower","great masterwort","siam tulip","lenten rose","barbeton daisy","daffodil"
    ,"sword lily","poinsettia","bolero deep blue","wallflower","marigold","buttercup","oxeye daisy"
    ,"common dandelion","petunia","wild pansy","primula","sunflower","pelargonium","bishop of llandaff"
    ,"gaura","geranium","orange dahlia","pink-Yellow dahlia","cautleya spicata","japanese anemone"
    ,"black-eyed susan","silverbush","californian poppy","osteospermum","spring crocus","bearded iris"
    ,"windflower","tree Poppy","gazania","azalea","water lily","rose","thorn apple"
    ,"morning glory","passion flower","lotus","toad lily","anthurium","frangipani","clematis"
    ,"hibiscus","columbine","desert rose","tree mallow","magnolia","cyclamen","watercress"
    ,"canna lily","hippeastrum","bee balm","pink quill","foxglove","bougainvillea","camellia"
    ,"mallow","mexican petunia","bromelia","blanket flower","trumpet creeper","blackberry lily"

)
// flower toxicity
val flower_toxicity = arrayOf(
    false, false, false, true, false, false, false, true, true, false, false, true,
    true, false, true, true, false, true, false, true, true, false, true, false, false,
    true, false, false, false, true, false, false, true, true, false, false, false, false,
    false, true, false, true, true, false, false, true, true, true, false, false, false, false,
    true, false, false, true, false, true, true, false, false, true, false, false, true, false,
    false, true, true, true, false, true, true, false, true, true, true, false, true, true,
    true, true, true, false, true, false, false, true, false, false, true, false, false,
    true, true, false, false, false, false, false, true, false

)
// flower wikipedia links
val flower_links = arrayOf(
     "https://en.wikipedia.org/wiki/Oenothera_speciosa","https://en.wikipedia.org/wiki/Paphiopedilum_micranthum"
    ,"https://en.wikipedia.org/wiki/Campanula_medium","https://en.wikipedia.org/wiki/Sweet_pea"
    ,"https://en.wikipedia.org/wiki/Tagetes","https://en.wikipedia.org/wiki/Lilium_lancifolium"
    ,"https://en.wikipedia.org/wiki/Phalaenopsis_amabilis","https://en.wikipedia.org/wiki/Strelitzia_reginae"
    ,"https://en.wikipedia.org/wiki/Aconitum","https://en.wikipedia.org/wiki/Echinops"
    ,"https://en.wikipedia.org/wiki/Antirrhinum","https://en.wikipedia.org/wiki/Tussilago"
    ,"https://en.wikipedia.org/wiki/Protea_cynaroides","https://en.wikipedia.org/wiki/Cirsium_vulgare"
    ,"https://en.wikipedia.org/wiki/Iris_pseudacorus","https://en.wikipedia.org/wiki/Trollius"
    ,"https://en.wikipedia.org/wiki/Echinacea_purpurea","https://en.wikipedia.org/wiki/Alstroemeria"
    ,"https://en.wikipedia.org/wiki/Platycodon","https://en.wikipedia.org/wiki/Zantedeschia"
    ,"https://en.wikipedia.org/wiki/Cyrtanthus_ventricosus","https://en.wikipedia.org/wiki/Scabiosa"
    ,"https://en.wikipedia.org/wiki/Fritillaria","https://en.wikipedia.org/wiki/Alpinia_purpurata"
    ,"https://en.wikipedia.org/wiki/Muscari","https://en.wikipedia.org/wiki/Papaver_rhoeas"
    ,"https://en.wikipedia.org/wiki/Amaranthus_hypochondriacus","https://en.wikipedia.org/wiki/Gentiana_acaulis"
    ,"https://en.wikipedia.org/wiki/Artichoke","https://en.wikipedia.org/wiki/Dianthus_barbatus"
    ,"https://en.wikipedia.org/wiki/Dianthus_caryophyllus","https://en.wikipedia.org/wiki/Phlox_paniculata"
    ,"https://en.wikipedia.org/wiki/Nigella_damascena","https://en.wikipedia.org/wiki/Cosmos_bipinnatus"
    ,"https://en.wikipedia.org/wiki/Eryngium_alpinum","https://en.wikipedia.org/wiki/Cattleya_labiata"
    ,"https://en.wikipedia.org/wiki/Nerine_bowdenii","https://en.wikipedia.org/wiki/Astrantia_major"
    ,"https://en.wikipedia.org/wiki/Curcuma_alismatifolia","https://en.wikipedia.org/wiki/Helleborus_orientalis"
    ,"https://en.wikipedia.org/wiki/Gerbera_jamesonii","https://en.wikipedia.org/wiki/Narcissus_(plant)"
    ,"https://en.wikipedia.org/wiki/Gladiolus","https://en.wikipedia.org/wiki/Poinsettia"
    ,"https://en.wikipedia.org/wiki/Eustoma_russellianum","https://en.wikipedia.org/wiki/Erysimum"
    ,"https://en.wikipedia.org/wiki/Tagetes","https://en.wikipedia.org/wiki/Ranunculus"
    ,"https://en.wikipedia.org/wiki/Leucanthemum_vulgare","https://en.wikipedia.org/wiki/Taraxacum_officinale"
    ,"https://en.wikipedia.org/wiki/Petunia","https://en.wikipedia.org/wiki/Viola_tricolor"
    ,"https://en.wikipedia.org/wiki/Primula","https://en.wikipedia.org/wiki/Common_sunflower"
    ,"https://en.wikipedia.org/wiki/Pelargonium","https://en.wikipedia.org/wiki/Dahlia_%27Bishop_of_Llandaff%27"
    ,"https://en.wikipedia.org/wiki/Gaura","https://en.wikipedia.org/wiki/Geranium","https://en.wikipedia.org/wiki/Dahlia_pinnata"
    ,"https://en.wikipedia.org/wiki/Dahlia","https://en.wikipedia.org/wiki/Cautleya_spicata"
    ,"https://en.wikipedia.org/wiki/Eriocapitella_hupehensis","https://en.wikipedia.org/wiki/Rudbeckia_hirta"
    ,"https://en.wikipedia.org/wiki/Convolvulus_cneorum","https://en.wikipedia.org/wiki/Eschscholzia_californica"
    ,"https://en.wikipedia.org/wiki/Osteospermum","https://en.wikipedia.org/wiki/Crocus_vernus"
    ,"https://en.wikipedia.org/wiki/Iris_%C3%97_germanica","https://en.wikipedia.org/wiki/Anemone"
    ,"https://en.wikipedia.org/wiki/Tree_poppy","https://en.wikipedia.org/wiki/Gazania"
    ,"https://en.wikipedia.org/wiki/Azalea","https://en.wikipedia.org/wiki/Nymphaeaceae"
    ,"https://en.wikipedia.org/wiki/Garden_roses","https://en.wikipedia.org/wiki/Datura_stramonium"
    ,"https://en.wikipedia.org/wiki/Morning_glory","https://en.wikipedia.org/wiki/Passiflora"
    ,"https://en.wikipedia.org/wiki/Nelumbo_nucifera","https://en.wikipedia.org/wiki/Tricyrtis"
    ,"https://en.wikipedia.org/wiki/Anthurium","https://en.wikipedia.org/wiki/Plumeria"
    ,"https://en.wikipedia.org/wiki/Clematis","https://en.wikipedia.org/wiki/Hibiscus"
    ,"https://en.wikipedia.org/wiki/Aquilegia","https://en.wikipedia.org/wiki/Adenium_obesum"
    ,"https://en.wikipedia.org/wiki/Malva_arborea","https://en.wikipedia.org/wiki/Magnolia"
    ,"https://en.wikipedia.org/wiki/Cyclamen","https://en.wikipedia.org/wiki/Watercress"
    ,"https://en.wikipedia.org/wiki/Zantedeschia","https://en.wikipedia.org/wiki/Hippeastrum"
    ,"https://en.wikipedia.org/wiki/Monarda","https://en.wikipedia.org/wiki/Wallisia_cyanea"
    ,"https://en.wikipedia.org/wiki/Digitalis_purpurea","https://en.wikipedia.org/wiki/Bougainvillea"
    ,"https://en.wikipedia.org/wiki/Camellia","https://en.wikipedia.org/wiki/Malva"
    ,"https://en.wikipedia.org/wiki/Ruellia_simplex","https://en.wikipedia.org/wiki/Bromelia"
    ,"https://en.wikipedia.org/wiki/Gaillardia","https://en.wikipedia.org/wiki/Campsis_radicans"
    ,"https://en.wikipedia.org/wiki/Iris_domestica"

)
// flower growing methods
val cult_methods = arrayOf(

    """Soil acidity: Slightly acidic to neutral
Light: Adaptable
Water: Moderate
Temperature: 15°C to 26°C""",
    """Soil acidity: 5.5-6.0
Light: Bright indirect light
Water: Every 5 days
Temperature: -1°C to 31°C""",
    """Soil acidity: 6.0-8.0
Light: Full sun
Water: Twice per week
Temperature: 18°C to 21°C""",
    """Soil acidity: 7.0-8.0
Light: Full sun
Water: 2 to 3 times per week
 Temperature: 10°C to 13°C""",
    """Soil acidity: 6.0-7.0
Light: Full sun
Water: Occasionally
Temperature: 20°C to 38 °C""",
    """Soil acidity: 6.0-7.0
Light: Full sun
Water: Once a week
Temperature: 15°C to 24 °C""",
    """Soil acidity: 5.2-6.5
Light: Bright indirect light
Water: Every 9 days
Temperature: 10°C to 29 °C""",
    """Soil acidity: 5.5-7.5
Light: Full sun
Water: Every 1 to 2 weeks
Temperature: 18°C to 27 °C""",
    """Soil acidity: 5.5-7.0
Light: Full sun
Water: Once a week 
Temperature: 0°C to 32 °C""",
    """Soil acidity: 5.1-6.0
Light: Full sun
Water: Twice per week
Temperature: 18°C to 24 °C""",
    """Soil acidity: 6.2-7.0
Light: Full sun
Water: Once per week
Temperature: 4°C to 20 °C""",
    """Soil acidity: 4.6-10.0
Light: Full sun
Water: Once every 9 days
Temperature: 10°C to 25 °C""",
    """Soil acidity: 5.5-6.5
Light: Full sun
Water: Once a week
Temperature: 20°C to 28 °C""",
    """Soil acidity: 6.0-8.0
Light: Full sun
Water: Once every 9 days
Temperature: 0°C to 35 °C""",
    """Soil acidity: 3.6-7.7
Light: Full sun
Water: Once every 9 days
Temperature: 18°C to 29 °C""",
    """Soil acidity: 5.0-7.0
Light: Full sun
Water: Once per week
Temperature: 0°C to 32 °C""",
    """Soil acidity: 6.5-7.2
Light: Full sun
Water: Once per week
Temperature: 20°C to 35 °C""",
    """Soil acidity: 5.5-6.5
Light: Full sun
Water: Once per week
Temperature: 20°C to 35 °C""",
    """Soil acidity: 5.5-7.5
Light: Bright indirect sunlight
Water: Once a week
Temperature: 15°C to 26 °C""",
    """Soil acidity: 6.0-6.5
Light: Full sun
Water: Regularly
Temperature: 10°C to 15 °C""",
    """Soil acidity: 5.8-6.5
Light: Partially shady
Water: Every 2 to 3 days
Temperature: 20°C to 38 °C""",
    """Soil acidity: 7.0-7.5
Light: Full sun
Water: 1 to 2 times per week
Temperature: 5°C to 32 °C""",
    """Soil acidity: 6.0-7.0
Light: Full sun
Water: One inch per week
Temperature: 0°C to 32 °C""",
    """Soil acidity: 5.5-6.8
Light: Full sun
Water: One inch per week
Temperature: 21°C to 35 °C""",
    """Soil acidity: 6.0-7.0
Light: Full sun
Water: Only when soil dries out
Temperature: 15°C to 25 °C""",
    """Soil acidity: 6.0-8.0
Light: Full sun
Water: Only when soil dries out
Temperature: 20°C to 35 °C""",
    """Soil acidity: 6.0-7.0
Light: Full sun
Water: 0.8 cups every 9 days
Temperature: 20°C to 35 °C""",
    """Soil acidity: 6.0-8.0
Light: Full sun
Water: Once per week
Temperature: 18°C to 25 °C""",
    """Soil acidity: 6.5-7.0
Light: Full sun
Water: 1 to 2 times per week
Temperature: 13°C to 22 °C""",
    """Soil acidity: 6.5-7.0
Light: Full sun
Water: Only when soil dries out
Temperature: 10°C to 13 °C""",
    """Soil acidity: 5.5-6.5
Light: Full sun
Water: Only when soil dries out
Temperature: 20°C to 35 °C""",
    """Soil acidity: 6.0-8.0
Light: Full sun
Water: One inch per week
Temperature: 20°C to 30 °C""",
    """Soil acidity: 6.0-7.0
Light: Full sun
Water: Occasionally
Temperature: 20°C to 35 °C""",
    """Soil acidity: 6.0-8.5
Light: Full sun
Water: Occasionally
Temperature: 20°C to 30 °C""",
    """Soil acidity: 6.1-7.8
Light: Full sun
Water: Only when soil dries out
Temperature: 13°C to 16 °C""",
    """Soil acidity: 6.0-7.0
Light: Bright indirect light
Water: Once per week
Temperature: 15°C to 32 °C""",
    """Soil acidity: 5.5-7.0
Light: Full sun
Water: 0.8 cups every 9 days
Temperature: 18°C to 24 °C""",
    """Soil acidity: 5.8-6.5
Light: Partial to full shade
Water: Only when soil dries out
Temperature: 20°C to 35 °C""",
    """Soil acidity: 6.0-7.8
Light: Bright indirect light
Water: When the top layer dries out
Temperature: 18°C to 24 °C""",
    """Soil acidity: 7.0-8.0
Light: Partial to full shade
Water: One inch per week
Temperature: 10°C to 25 °C""",
    """Soil acidity: 5.5-6.5
Light: Full sun
Water: One inch per week
Temperature: 4°C to 21 °C""",
    """Soil acidity: 6.0-7.0
Light: Full sun to partial shade
Water: One inch per week
Temperature: 15°C to 21 °C""",
    """Soil acidity: 6.5-7.0
Light: Full sun
Water: One inch per week
Temperature: 10°C to 25 °C""",
    """Soil acidity: 5.8-6.2
Light: Bright indirect light
Water: When the top layer dries out
Temperature: 13°C to 15 °C""",
    """Soil acidity: 5.5-6.0
Light: Full sun
Water: One inch per week
Temperature: -6°C to 0 °C""",
    """Soil acidity: 7.0-9.0
Light: Full sun
Water: Occasionally
Temperature: 20°C to 35 °C""",
    """Soil acidity: 6.0-7.0,
Light: Full sun to partial shade
Water: When the top layer dries out
Temperature: 18°C to 20 °C""",
    """Soil acidity: 5.8-7.0
Light: Full sun to partial shade
Water: Only when soil dries out
Temperature: 10°C to 24 °C""",
    """Soil acidity: 6.5-7.0
Light: Full sun to partial shade
Water: When soil dries out
Temperature: 5°C to 35 °C""",
    """Soil acidity: 4.0-8.0
Light: Full sun
Water: Once per week
Temperature: 18°C to 27 °C""",
    """Soil acidity: 6.0-7.0
Light: Full sun
Water: Once per week
Temperature: 15°C to 25 °C""",
    """Soil acidity: 5.4-5.8
Light: Full sun
Water: 0.8 cups every 9 days
Temperature: 5°C to 15 °C""",
    """Soil acidity: 5.5-6.2
Light: Light shade
Water: 0.8 cups every 9 days
Temperature: 5°C to 35 °C""",
    """Soil acidity: 6.0-6.8
Light: Full sun
Water: One inch per week
Temperature: 21°C to 26 °C""",
    """Soil acidity: 6.0-6.5
Light: Full sun to partial shade
Water: Once every 2 to 3 days
Temperature: 21°C to 29 °C""",
    """Soil acidity: 6.0-7.0
Light: Full sun
Water: Once per day
Temperature: 5°C to 15 °C""",
    """Soil acidity: 5.8-6.0
Light: Full sun
Water: Occasionally
Temperature: 13°C to 24 °C""",
    """Soil acidity: 6.0-6.5
Light: Full sun
Water: Once per week
Temperature: 18°C to 20 °C""",
    """Soil acidity: 6.2-6.5
Light: Full sun
Water: 1 to 3 times per week
Temperature: 15°C to 35 °C""",
    """Soil acidity: 6.6-7.0
Light: Full sun
Water: 1 to 2 times per week
Temperature: 15°C to 35 °C""",
    """Soil acidity: 6.5-7.5
Light: Partial shade
Water: Regularly
Temperature: 15°C to 35 °C""",
    """Soil acidity: 5.8-6.2
Light: Full sun
Water: Partial shade
Temperature: 25°C to 32 °C""",
    """Soil acidity: 6.0-6.8
Light: Full sun
Water: When the soil dries out
Temperature: 15°C to 30 °C""",
    """Soil acidity: 6.6-7.8
Light: Full sun
Water: Every 2 weeks
Temperature: 10°C to 16 °C""",
    """Soil acidity: 5.8-7.5
Light: Full sun
Water: Very little
Temperature: 15°C to 25 °C""",
    """Soil acidity: 6.0-6.2
Light: Full sun
Water: Regularly
Temperature: 7°C to 18 °C""",
    """Soil acidity: 6.0-7.0
Light: Full sun
Water: Regularly
Temperature: 2°C to 8 °C""",
    """Soil acidity: 6.0-7.8
Light: Full sun
Water: Occasionally
Temperature: 16°C to 27 °C""",
    """Soil acidity: 6.0-6.5
Light: Full sun to partial shade
Water: Regularly
Temperature: 0°C to 32 °C""",
    """Soil acidity: 5.0-8.0
Light: Full sun
Water: Occasionally
Temperature: 18°C to 27 °C""",
    """Soil acidity: 6.0-7.0
Light: Full sun
Water: Occasionally
Temperature: 14°C to 22 °C""",
    """Soil acidity: 4.5-5.5
Light: Bright indirect light
Water: Regularly
Temperature: 5°C to 35 °C""",
    """Soil acidity: 6.5-8.0
Light: Full sun
Water: Every 2 to 3 days
Temperature: 21°C to 35 °C""",
    """Soil acidity: 6.0-7.0
Light: Full sun to partial shadow
Water: Every 2 to 3 days
Temperature: 15°C to 28 °C""",
    """Soil acidity: 6.0-7.0
Light: Full sun
Water: 0.8 cups every 9 days
Temperature: 20°C to 35 °C""",
    """Soil acidity: 6.0-6.8
Light: Full sun
Water: Several times per week
Temperature: 20°C to 35 °C""",
    """Soil acidity: 3.5-5.5
Light: Full sun
Water: Deep watering once per week
Temperature: 10°C to 20 °C""",
    """Soil acidity: 4.5-5.5
Light: Full sun
Water: Keep at 5 cm above soil
Temperature: 24°C to 30 °C""",
    """Soil acidity: 6.0-7.0
Light: Full to partial shade
Water: Consistent watering
Temperature: 20°C to 35 °C""",
    """Soil acidity: 5.5-6.5
Light: Bright indirect light
Water: Once per week
Temperature: 20°C to 30 °C""",
    """Soil acidity: 5.0-6.0
Light: Full sun
Water: One inch per week
Temperature: 18°C to 29 °C""",
    """Soil acidity: 6.5-7.0
Light: Full sun
Water: Regular deep watering
Temperature: 15°C to 24 °C""",
    """Soil acidity: 6.5-6.8
Light: Full sun
Water: 1 to 2 times per week
Temperature: 15°C to 30 °C""",
    """Soil acidity: 5.0-7.5
Light: Full sun to partial shade
Water: Regularly
Temperature: 20°C to 35 °C""",
    """Soil acidity: 6.0-7.0
Light: Full sun
Water: Once every 1 to 2 weeks
Temperature: 15°C to 35 °C""",
    """Soil acidity: 6.0-7.0
Light: Full sun
Water: Once per week
Temperature: 18°C to 24 °C""",
    """Soil acidity: 5.5-6.5
Light: Full sun to partial shade
Water: Twice per week
Temperature: 18°C to 25 °C""",
    """Soil acidity: 6.0-7.0
Light: Bright indirect light
Water: Only when soil dries out
Temperature: 10°C to 20 °C""",
    """Soil acidity: 6.5-7.5
Light: Full sun to partial shade
Water: Keep soil moist
Temperature: 10°C to 12 °C""",
    """Soil acidity: 6.0-6.5
Light: Full sun
Water: Once a week
Temperature: 15°C to 32 °C""",
    """Soil acidity: 6.0-6.5
Light: Full sun
Water: Once per week
Temperature: 18°C to 23 °C""",
    """Soil acidity: 6.0-7.0
Light: Full sun
Water: Once every week
Temperature: 15°C to 21 °C""",
    """Soil acidity: 5.0-5.5
Light: Low to medium indirect light
Water: Soak for 30 min. once a week
Temperature: 15°C to 25 °C""",
    """Soil acidity: 5.5-6.5
Light: Full sun to light shade
Water: Once a week
Temperature: 20°C to 35 °C""",
    """Soil acidity: 5.5-6.0
Light: Full sun
Water: Only when top soil dries out
Temperature: 20°C to 38 °C""",
    """Soil acidity: 6.0-6.5
Light: Full sun
Water: Regularly
Temperature: 15°C to 21 °C""",
    """Soil acidity: 5.5-7.0
Light: Full sun
Water: Once a week
Temperature: 20°C to 35 °C""",
    """Soil acidity: 5.5-7.8
Light: Full sun to partial shade
Water: Keep soil moist
Temperature: 15°C to 38 °C""",
    """Soil acidity: 4.5-5.5
Light: Bright indirect to direct light
Water: Every 1 to 2 weeks
Temperature: 15°C to 25 °C""",
    """Soil acidity: 6.1-6.5
Light: Full sun
Water: 1 to 2 times per week
Temperature: 0°C to 35 °C""",
    """Soil acidity: 3.7-6.8
Light: Full sun
Water: Only when soil dries out
Temperature: 5°C to 35 °C""",
    """Soil acidity: 6.0-8.0
Light: Full sun to light shade
Water: 1 to 2 times per week
Temperature: 0°C to 18 °C"""

)
//flower images
val flower_images = arrayOf(
    R.drawable.f1, R.drawable.f2, R.drawable.f3, R.drawable.f4, R.drawable.f5, R.drawable.f6, R.drawable.f7, R.drawable.f8, R.drawable.f9, R.drawable.f10,
    R.drawable.f11, R.drawable.f12, R.drawable.f13, R.drawable.f14, R.drawable.f15, R.drawable.f16, R.drawable.f17, R.drawable.f18, R.drawable.f19,
    R.drawable.f20, R.drawable.f21, R.drawable.f22, R.drawable.f23, R.drawable.f24, R.drawable.f25, R.drawable.f26, R.drawable.f27, R.drawable.f28,
    R.drawable.f29, R.drawable.f30, R.drawable.f31, R.drawable.f32, R.drawable.f33, R.drawable.f34, R.drawable.f35, R.drawable.f36, R.drawable.f37,
    R.drawable.f38, R.drawable.f39, R.drawable.f40, R.drawable.f41, R.drawable.f42, R.drawable.f43, R.drawable.f44, R.drawable.f45, R.drawable.f46,
    R.drawable.f47, R.drawable.f48, R.drawable.f49, R.drawable.f50, R.drawable.f51, R.drawable.f52, R.drawable.f53, R.drawable.f54, R.drawable.f55,
    R.drawable.f56, R.drawable.f57, R.drawable.f58, R.drawable.f59, R.drawable.f60, R.drawable.f61, R.drawable.f62, R.drawable.f63, R.drawable.f64,
    R.drawable.f65, R.drawable.f66, R.drawable.f67, R.drawable.f68, R.drawable.f69, R.drawable.f70, R.drawable.f71, R.drawable.f72, R.drawable.f73,
    R.drawable.f74, R.drawable.f75, R.drawable.f76, R.drawable.f77, R.drawable.f78, R.drawable.f79, R.drawable.f80, R.drawable.f81, R.drawable.f82,
    R.drawable.f83, R.drawable.f84, R.drawable.f85, R.drawable.f86, R.drawable.f87, R.drawable.f88, R.drawable.f89, R.drawable.f90, R.drawable.f91,
    R.drawable.f92, R.drawable.f93, R.drawable.f94, R.drawable.f95, R.drawable.f96, R.drawable.f97, R.drawable.f98, R.drawable.f99, R.drawable.f100,
    R.drawable.f101, R.drawable.f102

)
