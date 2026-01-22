package com.example.armeria.objects_models

import com.example.armeria.models.Arma

object ArmasRepository : ArmaRepository {
    private val _listArmas: MutableList<Arma> = mutableListOf(
        Arma("Escopet Bereta", "Escopeta superpuesta", "2525€", "https://media.istockphoto.com/id/162394433/es/vector/escopeta.jpg?s=612x612&w=0&k=20&c=pcDf4NvADleiSILW_NlLSElrwPfgrs5cDp2fl0CaHrE=", "Escopeta de gran precisión y potencia."),
        Arma("Glock 19", "Pistola", "650€", "https://media.istockphoto.com/id/89485543/es/foto/glock.jpg?s=612x612&w=0&k=20&c=FBVvz42w78iLqI7c1X-XUctVr0q4SVGeaczMb65nEks=", "Pistola compacta muy usada por cuerpos de seguridad."),
        Arma("AK-47", "Rifle de asalto", "1200€", "https://media.istockphoto.com/id/177391994/es/foto/ak-47.jpg?s=612x612&w=0&k=20&c=0b72sUS-1k1lEWs9fcaZRjDFBZmQnUN076ot_g-r4bo=", "Rifle robusto, fiable en condiciones extremas."),
        Arma("Remington 870", "Escopeta de corredera", "780€", "https://media.v2.siweb.es/uploaded_thumb_big/9faac4f5e85394635fa025f4532af602/escopeta_remington_870_express_sintetica0_1.jpg", "Escopeta clásica de corredera, ideal para caza."),
        Arma("Colt M4", "Carabina", "1899€", "https://www.shutterstock.com/image-photo/us-army-carbine-isolated-on-600nw-104311109.jpg", "Carabina ligera y precisa para uso táctico."),
        Arma("Walther PPK", "Pistola compacta", "900€", "https://upload.wikimedia.org/wikipedia/commons/1/12/1972_Walther_PP.jpg", "Pistola pequeña, famosa por su uso en cine."),
        Arma("Sako TRG 22", "Rifle de precisión", "3200€", "https://media.sako.global/image/upload/t_product_hero_image/e_trim/dpr_2.0/f_auto/q_auto/c_scale/v1/Akeneo/j4gc1eqp6w4hpbexfika?_a=AJAUVWIA", "Rifle de largo alcance, muy preciso."),
        Arma("HK MP5", "Subfusil", "2500€", "https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Heckler_%26_Koch_MP5-1.jpg/960px-Heckler_%26_Koch_MP5-1.jpg", "Subfusil compacto usado en operaciones especiales.")
    )

    val listArmas: List<Arma> get() = _listArmas

    override fun getArmas(): List<Arma> = _listArmas

    fun addArma(arma: Arma) {
        _listArmas.add(arma)
    }

    fun updateArma(position: Int, arma: Arma) {
        if (position >= 0 && position < _listArmas.size) {
            _listArmas[position] = arma
        }
    }

    fun deleteArma(position: Int) {
        if (position >= 0 && position < _listArmas.size) {
            _listArmas.removeAt(position)
        }
    }
}