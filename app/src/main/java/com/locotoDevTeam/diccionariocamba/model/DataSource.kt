package com.locotoDevTeam.diccionariocamba.model

import com.locotoDevTeam.diccionariocamba.R

class DataSource {

    fun loadImages(): List<ImageSC> = listOf<ImageSC>(
        ImageSC(R.drawable.image1),
        ImageSC(R.drawable.image2),
        ImageSC(R.drawable.image3),
        ImageSC(R.drawable.image4),
        ImageSC(R.drawable.image5),
    )

    fun loadDatabaseFirstTime(): List<Dictionary> = listOf<Dictionary>(
        Dictionary(1, "Acopaibao", "Se le dice al individuo torpe, de reacciones tardías."),
        Dictionary(2, "Afiltracao", "Bien vestido."),
        Dictionary(3, "Ajilar", "Agriar, fermentar."),
        Dictionary(4, "Almondrote", "Comida de plátano verde y queso."),
        Dictionary(
            5,
            "Amboró",
            "Según la leyenda, un cacique que se tranformó en el cerro al cual le dio su nombre."
        ),
        Dictionary(6, "Anatuya", "Pequeño cuadrúpedo que da mal olor."),
        Dictionary(7, "Apasanca", "Arácnido peludo y ponzoñoso."),
        Dictionary(8, "Apestar", "Heder"),
        Dictionary(10, "Asimplao", "Persona que es chistosa, simple en sus acciones."),
        Dictionary(11, "Atintilao", "Acopaibao."),
        Dictionary(12, "Aurita", "En este mismo instante. También se dice \" ahorita \"."),
        Dictionary(
            13,
            "Baquitú",
            "Soplador. Especie de abanico que se usa para avivar el fuego, hecho de hojas de motacú o del cogollo de alguna palmera."
        ),
        Dictionary(14, "Barapucú", "Voz guaraní que significa árbol alto."),
        Dictionary(
            15,
            "Barraca",
            "En la época de la siringa se le llamaba a los puestos o establecimientos, actualmente se usa en las provincias Velasco y Ñuflo de Chaves."
        ),
        Dictionary(16, "Barreno", "Melaza."),
        Dictionary(17, "Bato", "Ave del orden de las Zancudas."),
        Dictionary(18, "Bentón", "Pez de la familia de los Gádidos."),
        Dictionary(19, "Besa", "Afluente del río Moreno"),
        Dictionary(
            20,
            "Bicubico",
            "Cierto juguete de madera, que consiste en dos maderas y un muñeco, en el centro, colgado de un trapecio de pita."
        ),
        Dictionary(21, "Bloqui", "Acto de percutir con el dedo en la oreja de otra persona."),
        Dictionary(
            22,
            "Bocó",
            "Especie de morral de los cazadores para llevar enseres de cacería, o su \" tapeque \"."
        ),
        Dictionary(23, "Bodoqui", "Arco de madera, con cuerda para lanzar flechas."),
        Dictionary(
            24,
            "Borequi",
            "Especie de la familia de las ranas. Se los ve pegados en las paredes y árboles."
        ),
        Dictionary(
            25,
            "Borochi",
            "Chacal, lobo de América. Felino de la familia de los cánidos (Canis rifus)."
        ),
        Dictionary(26, "Boyé", "Variedad de boa."),
        Dictionary(27, "Bulto", "Fantasma, aparecido."),
        Dictionary(28, "Buraca", "Bolsa tejida con hojas de motacú."),
        Dictionary(29, "Buracú", "Cuero de ganado en el cual se guarda arroz."),
        Dictionary(
            30,
            "Buri",
            "Baile de arrabal, fiesta criolla ruidosa y alegre. Se la realiza en domicilios."
        ),
        Dictionary(31, "Busubusu", "Impresión que produce el miedo en el esfínter anal."),
        Dictionary(32, "Busutaraco", "Lo que se esfuma."),
        Dictionary(33, "Butucún", "Flor cerrada y cubierta por los sépalos, botón de flor."),
        Dictionary(34, "Butunta", "Imbécil."),
        Dictionary(35, "Cabrestear", "Seguir a la presa."),
        Dictionary(36, "Cacha", "Baúl, arca de madera."),
        Dictionary(37, "Cachuela", "Rompiente en la curva de los ríos."),
        Dictionary(38, "Caichuné", "Angurria de devorar."),
        Dictionary(39, "Callapo", "Balsa para navegación en los ríos."),
        Dictionary(
            40,
            "Camba",
            "Nombre con que se conoce a los indígenas civilizados del Oriente boliviano."
        ),
        Dictionary(41, "Cambijochi", "Indio guaraní de pura sangre. Pelada."),
        Dictionary(42, "Canchón", "Patio."),
        Dictionary(43, "Candirú", "Pez de río."),
        Dictionary(45, "Caneco", "Vaso con asa para beber agua, hecho generalmente de guayacán."),
        Dictionary(46, "Capirotada", "Guiso de harina de maíz, queso y carne."),
        Dictionary(47, "Carnaval", "Música típica de Santa Cruz en compases de seis por ocho."),
        Dictionary(48, "Catinga", "Aficionado a vestir bien."),
        Dictionary(
            49,
            "Cocererú",
            "Chuisaó o peji llorón. Desdentado que vive en cuevas bajo tierra. Emite un ruído como llanto de niño recién nacido."
        ),
        Dictionary(50, "Cochoé", "Pato."),
        Dictionary(
            51,
            "Coleador",
            "Sablista. Persona que se apega a otras para aprovechar las atenciones de una fiesta. Conjeturando Se dice del tiempo cuando oscurece para llover. Cambio atmosférico."
        ),
        Dictionary(52, "Coñichi", "Residuos del cumpleaños anterior."),
        Dictionary(53, "Corechi", "Desdentado pequeño, parecido al armadillo."),
        Dictionary(54, "Cotibí", "Raya que se hace en el cabello para compartirlo en el peinado."),
        Dictionary(55, "Cotiojo", "Mirar de reojo."),
        Dictionary(56, "Cuchuqui", "Sucio."),
        Dictionary(57, "Cuco", "Cigarra."),
        Dictionary(58, "Cujuchi", "Topo."),
        Dictionary(59, "Cunumi", "Niño, muchacho indígena civilizado."),
        Dictionary(60, "Cuña", "Mujer guaraya o guaraní."),
        Dictionary(61, "Cuñapé", "Pan de almidón y queso."),
        Dictionary(62, "Cuquisa", "Paloma cuyo tamaño media entre la chaicita y la torcaza."),
        Dictionary(63, "Curichi", "Pantano, lodazal."),
        Dictionary(64, "Curucusí", "Luciérnaga (Lampirus noctiluca)."),
        Dictionary(65, "Cutuchi", "Vertebrado del orden de los Apodos (Cecilia Lumbricoides)."),
        Dictionary(66, "Cuyabo", "Ave nocturna."),
        Dictionary(67, "Chaco", "Terreno con sementera."),
        Dictionary(68, "Chafra", "Astillas de leña o pedazos de ramas secas."),
        Dictionary(69, "Chaicita(Chai)", "Especie de paloma pequeña."),
        Dictionary(70, "Chananga", "En el juego de las bolas."),
        Dictionary(
            71,
            "Chapulear",
            "Lo que ocurre, por el movimiento, cuando en un recipiente se lleva líquido."
        ),
        Dictionary(72, "Chaquira", "Bolas de cristal pequeñas."),
        Dictionary(73, "Chara", "Rana de color verde (Ila Arvborea)."),
        Dictionary(74, "Charachará", "Masita de clara de huevo con azúcar."),
        Dictionary(75, "Charapa", "Camastro."),
        Dictionary(76, "Charque", "Carne seca."),
        Dictionary(
            77,
            "Charuto",
            "Cigarro de tabaco negro, envuelto en hojas finas de chala de maíz."
        ),
        Dictionary(78, "Cheruje", "Comida."),
        Dictionary(79, "Chicha", "Bebida refrescante hecha de harina de maíz."),
        Dictionary(80, "Chichuriro", "Pájaro pequeño muy casero."),
        Dictionary(81, "Chicó", "Estremecimiento de los nervios. Adormecimiento de los músculos."),
        Dictionary(82, "Chicote", "Látigo."),
        Dictionary(83, "Chilchi", "Llovizna."),
        Dictionary(84, "Chima", "Pan de jachi de maíz, con carne y queso."),
        Dictionary(85, "Chimori", "Aborígenes de la provincia Velasco."),
        Dictionary(86, "Chinga", "Dícese de lo que ha desaparecido."),
        Dictionary(87, "Chiñi", "Ave nocturna de la familia de las lechuzas."),
        Dictionary(
            88,
            "Chiñuelo",
            "Los que volvían de las regiones gomeras, bien vestidos y rumboso, para aparentar que allá se ganaba bien; esto con el objeto de atraer otros individuos a la industria gomera, dentro de la modalidad del \" reenganche \" (H.S.F.)."
        ),
        Dictionary(89, "Chío", "Cariado."),
        Dictionary(
            90,
            "Chipeno",
            "Vasija de barro cocido, sin asa, más pequeño que el tichibó. Se emplea generalmente para echar somó o chicha."
        ),
        Dictionary(91, "Chiquiyú", "Ligoso."),
        Dictionary(92, "Chirapa", "Prenda de vestir raída y vieja."),
        Dictionary(93, "Chivé", "Harina que se obtiene de la yuca."),
        Dictionary(94, "Chivo", "Juego popular de El Palmar. Muy famoso el de la familia Alpire."),
        Dictionary(95, "Choco(a)", "Persona de cabello castaño claro."),
        Dictionary(96, "Cholón", "Sonadijo de la barriga."),
        Dictionary(
            97,
            "Chopochoro",
            "Pájaro, cuyo canto es semejante a su nombre."
        ),
        Dictionary(98, "Chori", "Nombre que se da a los indios salvajes."),
        Dictionary(
            99,
            "Choropa",
            "Indígena de la provincia Ichilo, perteneciente al grupo étnico y lingüistico Chiquito. En castellano: amigo (H.S.F.)."
        ),
        Dictionary(100, "Chota", "Muchacha joven."),
        Dictionary(101, "Chotota", "Hormiga grande que se alimenta especialmente de azúcar."),
        Dictionary(
            102,
            "Chovena",
            "Música nativa de Santa Cruz que se escribe en compases de tres por cuatro."
        ),
        Dictionary(103, "Chulún", "Caer en el agua."),
        Dictionary(104, "Chulupaca", "Variedad de chulupi, mucho más grande."),
        Dictionary(105, "Chulupi", "Cucaracha. Chunchulíses.Menudo de tripa delgada de res."),
        Dictionary(106, "Chupa", "Adulón y servil."),
        Dictionary(
            107,
            "Chupliqui",
            "Persona delgada. Tambien se le dice a la mujer que usa el vestido muy ajustado, ceñido."
        ),
        Dictionary(
            108,
            "Churuno",
            "Vasija hecha de tutuma con boca ancha y tapa, para guardar sólidos."
        ),
        Dictionary(109, "Chuto", "Corto, inconcluso."),
        Dictionary(
            110,
            "Chuturubí",
            "Avispa agresiva y de picadura muy dolorosa. Se aplica también al individuo que acomete ciego de cólera (H.S.F.)."
        ),
        Dictionary(111, "Deñeque", "Hombre fuerte, de agallas."),
        Dictionary(112, "Depliqi", "De mentira."),
        Dictionary(113, "Dejuañango", "Desorden de cosas."),
        Dictionary(114, "Ejene", "Insecto hematófago."),
        Dictionary(115, "Elay(Helay)", "Helo ahí."),
        Dictionary(116, "Empacarse", "Encapricharse"),
        Dictionary (117,
        "Emplumarla",
        "Huir, irse, desaparecer"
    ),
    Dictionary(118, "Emponchao", "Cigarrillo de tabaco negro ordinario, envuelto a mano."),
    Dictionary(119, "Emporrar", "Apareamiento de animales cuadrúpedos."),
    Dictionary(120, "Encocorarse", "Alborotarse"),
    Dictionary(121, "Enrollao", "Carne de cerdo preparada en forma de rollos."),
    Dictionary(122, "Entierro", "Tesoro oculto o enterrado en el suelo."),
    Dictionary(123, "Eredeú", "Abeja."),
    Dictionary(124, "Escuro", "Oscuro. Antiguamente se decía en Santa Cruz \"ehjcuro\", \"ehjcurana\"."),
    Dictionary(125, "Fajinista", "Persona porfiada y testaruda."),
    Dictionary(126, "Fefeinte", "Dos veces veinte."),
    Dictionary(127, "Funfuñó", "Canto lúgubre de ciertas aves."),
    Dictionary(128, "Gambeta", "Modales graciosos del rostro o del cuerpo que hace un hombre a una mujer o viceversa. Coquetería."),
    Dictionary(129, "Grigotá", "Cacique de los indios chanés, primitivos pobladores de Santa Cruz."),
    Dictionary(130, "Guacha", "Dícese del animal huérfano."),
    Dictionary(131, "Guajojó", "Ave nocturna, la más pequeña de los búhos, que emite un canto lúgubre y largo, análogo a una serie de gemidos (H.S.F.). Antes se creía que era de mala suerte."),
    Dictionary(132, "Guampa", "Corneta (asta) del marucho."),
    Dictionary(133, "Guarayo", "Indígena de la tribu de ese nombre, de estirpe guaraní."),
    Dictionary(134, "Guariflé", "Bebida de huevo batido en agua caliente con licor."),
    Dictionary(135, "Guatía", "Cabeza de res preparada y asada al horno."),
    Dictionary(136, "Horquillazo", "Empujón con la mano en palca, dado en el cuello de otro."),
    Dictionary(137, "Insirirí", "Raquítico."),
    Dictionary(138, "Jaba", "Encías crecidas de los caballos."),
    Dictionary(139, "Jachi", "Sedimento de café o desechos de harina de maíz."),
    Dictionary(140, "Jacuú", "Pan, yuca o algo similiar que se acompaña con la comida o bebida."),
    Dictionary(141, "Jancara", "Mate de gran tamaño."),
    Dictionary(142, "Janucho", "Farsante. Simple."),
    Dictionary(143, "Jara", "Hojas de palmera, colocadas a manera de techo de una agua, que hacen los campesinos o cazadores para resguardarse de la lluvia."),
    Dictionary(144, "Jarichi", "Tira de trapo a manera de trenza para el cabello."),
    Dictionary(145, "Jarón", "Cansado por trabajo bajo el sol tropical."),
    Dictionary(146, "Jasayé", "Tejido de hojas de motacú en forma de bolsa."),
    Dictionary(147, "Jatapú", "Espuma que produce el jabón."),
    Dictionary(148, "Jato", "Una pieza o conjunto de ropa."),
    Dictionary(149, "Jau", "Voz equivalente a ¡oye!"),
    Dictionary(150, "Jausi", "Reptil de color verde, media entre la lagartija y el peni."),
    Dictionary(151, "Javajú", "Resto de jabón. Fruta que mientras más madura, más fruncida."),
    Dictionary(152, "Jeborá", "Desecho en los panales de miel."),
    Dictionary(153, "Jenecherú", "Leña gruesa o tizón que se deja arder toda la noche sin apagarse, para que amanezca fuego."),
    Dictionary(154, "Jetapú", "Cuña. Lo que se incrusta por debajo de una cosa para que se fije."),
    Dictionary(155, "Ji", "Voz de mando para los bueyes"),
    Dictionary(156, "Jichi", "Monstruo fabuloso que, se dice, habita en ciertas lagunas que no se secan nunca. Persona diestra para ciertas actividades."),
    Dictionary(157, "Jichimora", "Variedad de ofidio."),
    Dictionary(158, "Jichiquií", "Astillas largas y flexibles que se sacan de las hojas de motacú."),
    Dictionary(159, "Jichitarumá", "Variedad de pájaro."),
    Dictionary(160, "Jichuchí", "Desechos de maíz seleccionado."),
    Dictionary(161, "Jigote", "Relleno de la empanada u otro plato."),
    Dictionary(162, "Jipato", "Flojedad de los caballos cuando comienzan a engordar."),
    Dictionary(163, "Jipurí", "Raicilla interior de la yuca."),
    Dictionary(164, "Jisunú", "Huevo sobre el que pone la gallina."),
    Dictionary(165, "Jitamucú", "Estiércol de perro."),
    Dictionary(166, "Jobobosí", "Especie de abeja silvestre."),
    Dictionary(167, "Jocha", "Trastada."),
    Dictionary(168, "Jochear", "Sinónimo de torear."),
    Dictionary(169, "Jochi", "Roedor silvestre que ataca las sementeras."),
    Dictionary(170, "Joíchi", "Polilla."),
    Dictionary(171, "Jometoto", "Espátula grande de madera para batir ciertos alimentos en su preparación."),
    Dictionary(172, "Jone", "Pedazo de ladrillo."),
    Dictionary(173, "Jopo", "Mechón de cabello que sobresale en la cabeza."),
    Dictionary(174, "Jorebaré", "Hormiga pequeña de color rojizo y olor penetrante."),
    Dictionary(175, "Jucumari", "Oso sudamericano."),
    Dictionary(176, "Jumbacá", "Estiércol de ganado vacuno."),
    Dictionary(177, "Jumbarayú", "Estiércol de gallina."),
    Dictionary(178, "Jumechi", "Aguardiente."),
    Dictionary(179, "Jumetrear", "Fastidiar, zarandear."),
    Dictionary(180, "Keresa", "Huevos de mosca sobre la carne."),
    Dictionary(182, "Lampión", "Lámpara a kerosén."),
    Dictionary(183, "Locro", "Comida de arroz, carne y yuca o plátano."),
    Dictionary(184, "Lopopo", "Párpado hinchado."),
    Dictionary(185, "Machorro", "Apelativo que se le da indistintamente al humano y al animal que no procrea. ."),
    Dictionary(186, "Macono", "Ave de rapiña que caza al vuelo a las víboras."),
    Dictionary(187, "Maipubá", "Afluente del Güendá; corre entre los ríos El Pato y Jorge."),
    Dictionary(188, "Majao", "Comida de arroz con carne majada."),
    Dictionary(189, "Mamesó", "Desvencimiento de cabeza."),
    Dictionary(190, "Manechi", "Especie de mono grande, cotudo."),
    Dictionary(191, "Manene", "Que mana."),
    Dictionary(192, "Mañaso", "El que derriba ganado para vender carne o destinarla al consumo de la hacienda."),
    Dictionary(193, "Maraca", "Redoblar del tambor como preludio para la ejecución de un carnaval."),
    Dictionary(194, "Marigüí", "Mosquito cuya picadura, bastante molesta, deja debajo de la piel una gota de sangre."),
    Dictionary(195, "Masaco", "Pasta de yuca o plátano cocido, con carne, chicharrón o queso, molida en tacú."),
    Dictionary(196, "Matato", "Cucharón hecho de una fruta para trasvasijar líquidos. \"Buenos matatos\": buenas razones."),
    Dictionary(197, "Matatuza", "Golpe en la mano de otra persona para hacer caer la cosa tenida."),
    Dictionary(198, "Mate", "Vasija hecha del fruto de esa planta."),
    Dictionary(199, "Matufia", "Malos manejos económicos. Fraude."),
    Dictionary(200, "Matusi", "Caballo viejo y flaco."),
    Dictionary(201, "Mauri", "Pájaro negro insectívoro que vive en los barbechos."),
    Dictionary(202, "Metapaso", "Juego de niños."),
    Dictionary(203, "Michi", "Gato."),
    Dictionary(204, "Minga", "Trabajo campestre que se hace por comida en un solo día."),
    Dictionary(205, "Mocheó", "Estado enfermizo de los niños, creyéndose su contagio por la exhalación del gas de los muertos."),
    Dictionary(206, "Mocherú", "Planta que tumba sus flores sin llegar a dar fruto."),
    Dictionary(207, "Moncontrullo", "Hueso gordo que sirve para sustanciar la comida."),
    Dictionary(208, "Monocotudo", "Manechi de color rojizo."),
    Dictionary(209, "Muchirí", "Tambo, cuyo nombre se le aplicó a un barrio de la ciudad de Santa Cruz de la Sierra."),
    Dictionary(210, "Murucuyá", "Fruta comestible de la familia sapotáceas."),
    Dictionary(211, "Musunguelas", "Muchachas callejeras."),
    Dictionary(212, "Mutún", "Serranía con una colosal reserva de hierro y manganeso."),
    Dictionary(213, "Ñamurucú", "Reunir escasos ingredientes para un locro. Cambio."),
    Dictionary(214, "Ocoró", "Estado de la comida agria."),
    Dictionary(215, "Orocepeó", "Variedad de abeja silvestre."),
    Dictionary(216, "Osamenta", "Cadáver descompuesto"),
    Dictionary(217, "Paco", "Soldado de policía."),
    Dictionary(218, "Paculita", "Lorita de muchos colores."),
    Dictionary(219, "Pacumuto", "Varilla de madera que sirve para asar carne."),
    Dictionary(220, "Pagüichi", "Casa rústica de campo, techada con hojas de motacú."),
    Dictionary(221, "Pajona", "Muchacha v.a."),
    Dictionary(222, "Palometa", "Pez muy voraz. Piraña ."),
    Dictionary(223, "Panacú", "Tejido de hojas de motacú a manera de bolsa pero más grande que el jasayé."),
    Dictionary(224, "Paraba", "Guacamayo."),
    Dictionary(225, "Parichi", "Estera trenzada con una sola hoja de motacú."),
    Dictionary(226, "Patasca", "Comida de carne y maíz."),
    Dictionary(227, "Patengue", "Los que no pisan firmes."),
    Dictionary(228, "Patuleca", "Dícese de la persona cuyas piernas hacen dengues al caminar."),
    Dictionary(229, "Paúro", "Pozo de agua poco profundo."),
    Dictionary(230, "Pelada", "Niña, muchacha joven."),
    Dictionary(231, "Peni", "Reptil de la familia de los Saurios."),
    Dictionary(232, "Peroquí", "Gallinazo de cabeza y cuello desplumado; se alimenta de osamentas. Ave de rapíña."),
    Dictionary(233, "Peta", "Tortuga."),
    Dictionary(234, "Peto", "Avispa."),
    Dictionary(235, "Picao", "Comida de arroz, carne y yuca picada."),
    Dictionary(236, "Pichaí", "Plegado, fruncido. Referente a los géneros."),
    Dictionary(237, "Pichi", "Pene."),
    Dictionary(238, "Pichiró", "Sabor de la fruta que no está bien madura."),
    Dictionary(239, "Pico", "Colmena de abeja silvestre."),
    Dictionary(240, "Pije", "Bien vestido."),
    Dictionary(241, "Pila", "Pies descalzos."),
    Dictionary(242, "Pinganillo", "Pije, elegante."),
    Dictionary(243, "Piroco", "Gallo pescueso pelado."),
    Dictionary(244, "Pitaí", "Erupción cutánea con escozor, producida por el calor."),
    Dictionary(245, "Piyo", "Avestruz."),
    Dictionary(246, "Plequecó", "Desvensijado."),
    Dictionary(247, "Pochecó", "Aburrido, hastiado, acobardado."),
    Dictionary(248, "Pohmeta", "Camba trompeta, con mal humor."),
    Dictionary(249, "Pollenquenque Mentecato, tonto y destraído", "Mentecato, tonto y destraído."),
    Dictionary(250, "Ponjear", "Paunjesear. Colocar el maiz todavía en chala, atado por dos extremos de las hojas, a manera de alforja."),
    Dictionary(251, "Popechi", "Que tiene un dedo más."),
    Dictionary(252, "Popí", "Manchas producidas por hongos en la ropa que se deja amontonada, humeda y a medio lavar."),
    Dictionary(253, "Pororó", "Tostado de maíz que revienta a guisa de flor."),
    Dictionary(254, "Posetacú", "Hormiguero formado en las ramas de los gruesos árboles."),
    Dictionary(255, "Puchapucha", "Planta despreciable."),
    Dictionary(256, "Puguilla", "Adolescente."),
    Dictionary(257, "Puján", "Pan de maíz a la ligera."),
    Dictionary(258, "Pujusó", "Lama u hongos que por efecto de la humedad cubren las cosas."),
    Dictionary(259, "Pululé", "Persona de carnes flojas y descolgadas."),
    Dictionary(260, "Punilla", "Especie de antesala, descubierto de paredes, en una casa de campo."),
    Dictionary(261, "Putirí", "Variedad de pato salvaje volador."),
    Dictionary(262, "Pututo", "Guiso de harina de maíz con carne."),
    Dictionary(263, "Quiboro", "Canasto hecho de hojas de motacú, semiaplastado, circular y sin asa."),
    Dictionary(264, "Quichote", "Raíz central, larga y fuerte de los árboles."),
    Dictionary(265, "Quirichí", "Verruga."),
    Dictionary(266, "Quisa", "Plátano maduro, asoleado."),
    Dictionary(267, "Quitabusi", "Mosca tornasolada de tamaño considerable."),
    Dictionary(268, "Rocorroco", "Insecto hematófago."),
    Dictionary(269, "Rosca", "Masa horneada de maíz con queso en forma de argolla."),
    Dictionary(270, "Sabandija", "Manga de insectos, mosquitos, ejenes, marigüises."),
    Dictionary(271, "Safacoca", "Persona desaforada."),
    Dictionary(272, "Sama", "Araña."),
    Dictionary(273, "Saó", "Sombrero hecho de fibras de la palmera del mismo nombre."),
    Dictionary(274, "Sapirá", "Lagañoso."),
    Dictionary(275, "Sapocó", "De sapo."),
    Dictionary(276, "Sarao", "Danza típica."),
    Dictionary(277, "Sarasaó", "Color azul que resalta en la yuca maleada."),
    Dictionary(278, "Saró", "Dícese de la epidermis escamosa por efecto de la sequedad del ambiente."),
    Dictionary(279, "Sarobabó", "Se dice al que está decepcionado, por su miedo o tristeza disimulados."),
    Dictionary(280, "Sarobaró", "Aparato de palo para acompañar dos hilos que tratan de torcer."),
    Dictionary(281, "Sayubú", "Variedad de pájaro."),
    Dictionary(282, "Seboí", "Variedad de pájaro de color negro."),
    Dictionary(283, "Sepe", "Hormiga parecida al setochi pero más grande y muy voraz."),
    Dictionary(284, "Seraquití", "Cera pegajosa."),
    Dictionary(285, "Serebó", "Meloso."),
    Dictionary(286, "Serere", "Variedad de pájaro."),
    Dictionary(287, "Sernambí", "Goma recogida de la corteza de la siringa llena de impurezas."),
    Dictionary(288, "Sicurí", "Boa (Boa contrictor)."),
    Dictionary(289, "Silbaco", "Duende."),
    Dictionary(290, "Simiusi", "Persona delgada y pequeña de estatura. Débil."),
    Dictionary(291, "Singa", "Vara larga para impulsar embarcaciones."),
    Dictionary(292, "Sirari", "Ofidio."),
    Dictionary(293, "Sirionó", "Indígena salvaje y belicoso de las selvas de Santa Cruz."),
    Dictionary(294, "Siripa", "Mujer habladora sin miramiento."),
    Dictionary(295, "Siripi", "Lo que queda en el urupé, después de colar la chicha."),
    Dictionary(296, "Somó", "Chicha con mote de maíz."),
    Dictionary(297, "Soqui-son-fon", "Se dice del animal que por haber corrido mucho, se le afloja el esfínter anal, dando paso al aire en calidad de fuelle."),
    Dictionary(298, "Suasar", "Poner la yuca entre las brasas o llamas, para después pelarlas y azarlas."),
    Dictionary(299, "Sucha", "Gallinazo, buitre."),
    Dictionary(300, "Suchi", "Conscripto, soldado recluta."),
    Dictionary(301, "Sucumbé", "Bebida compuesta de leche, huevo, licor y canela."),
    Dictionary(302, "Sumaqui", "Corteza curtiente que se extrae del árbol llamado curupaú."),
    Dictionary(303, "Sumurucucu", "Ave nocturna."),
    Dictionary(304, "Suniacá", "Comida de maíz."),
    Dictionary(305, "Supumó", "Fieros que se hacen a una persona, haciendo ver que está mejor con otra."),
    Dictionary(306, "Suraso", "Viento fuerte y frío del sur."),
    Dictionary(307, "Surubí", "Pez de la familia de los Gádidos."),
    Dictionary(308, "Tababé", "De formas torcidas."),
    Dictionary(309, "Table", "En el juego de las bolas."),
    Dictionary(310, "Tachobobó", "Una cosa que no es dura ni blanda."),
    Dictionary(311, "Tacú", "Mortero de madera."),
    Dictionary(312, "Tacuarilla", "Arma primitiva a guisa de escopeta de un solo cañón."),
    Dictionary(313, "Tacuchiri", "Persona con defectos en el nudo de la pierna. \"Taculiqui\"."),
    Dictionary(314, "Tacupé", "Polvo de tiesto que sirve para amalgamar el barro de loza."),
    Dictionary(315, "Taitetú", "Puerco pequeño del monte."),
    Dictionary(316, "Tajunó", "Amanecido de mala cara."),
    Dictionary(317, "Tapeque", "Vitualla, avío."),
    Dictionary(318, "Tapiosí", "Insecto nocturno que da luz instantánea."),
    Dictionary(319, "Tapití", "Liebre."),
    Dictionary(320, "Tapora", "Mujer crespa, de cabello ensortijado."),
    Dictionary(321, "Taquirari", "Música típica de Santa Cruz."),
    Dictionary(322, "Tarabilla", "Dispositivo en el aparato que sirve para hacer cabestros."),
    Dictionary(323, "Taracoé", "Ave del orden de las Zancudas."),
    Dictionary(324, "Tarechi", "Loro salvaje, de canto muy ruidoso, que nunca llega a hablar, aunque se crie en cautiverio."),
    Dictionary(325, "Tari", "Vasija hecha de tutuma con orificio angosto para echar líquidos."),
    Dictionary(326, "Tataracó", "Demasiado cuchuqui."),
    Dictionary(327, "Tatú", "Armadillo."),
    Dictionary(328, "Tembleque", "Persona que sufre del mal de Parkinson."),
    Dictionary(329, "Tibibi", "Ave pequeña del orden de las Zancudas."),
    Dictionary(330, "Tichela", "Vaso de hojalata en que se recibe el látex de la goma."),
    Dictionary(331, "Tichibó", "Vasija, con dos orejas, hecha de barro cocido. Se utiliza generalmente para echar chicha."),
    Dictionary(332, "Tijereta", "Ave de la familia tyrannidae, cuya cola es bifurcada."),
    Dictionary(333, "Tilburí", "Coche de dos ruedas tirado por un caballo, usado antiguamente en la ciudad de Santa Cruz de la Sierra."),
    Dictionary(334, "Tiluchi", "Hornero."),
    Dictionary(335, "Tipoi", "Vestimenta exterior de uso femenino en tela delgada; la llevan las cuñas."),
    Dictionary(336, "Tiquiminiqui", "Se emplea cuando se advierte un engaño; quiere decir: \"te pelaste\"."),
    Dictionary(337, "Tirirú", "Vacín de tutuma partida por la mitad."),
    Dictionary(338, "Toco", "Trozo de madera para sentarse."),
    Dictionary(339, "Tolón", "Se dice a la persona de poco talento. Simple."),
    Dictionary(340, "Tolondro", "Hombre de poco talento."),
    Dictionary(341, "Toruno", "Toro que ha sido castrado en viejo."),
    Dictionary(342, "Trasao", "Machete."),
    Dictionary(343, "Trompeta", "Persona enojada o \"empacada\"."),
    Dictionary(344, "Tucura", "Insecto de la familia de las langostas, al que también se le llama \"visita\"."),
    Dictionary(345, "Tui", "Ave de la familia de los rapaces."),
    Dictionary(346, "Tujuré", "Alimento de maíz, pelado con lejía."),
    Dictionary(347, "Turiro", "Insecto que destruye la madera reduciéndola a polvo. Termita."),
    Dictionary(348, "Turumba", "Aturdido."),
    Dictionary(349, "Turupé", "Lo que tiene muchos agujeros."),
    Dictionary(350, "Turuteadora", "Arrulladora."),
    Dictionary(351, "Tutuma", "Calabaza que sirve como recipiente para muchos usos. Fruto del tutumo."),
    Dictionary(352, "Tuyuyo", "Ombligo largo, brotado."),
    Dictionary(353, "Urina", "Gacela."),
    Dictionary(354, "Urupé", "Cedazo o tamiz de fibras de saó."),
    Dictionary(355, "Urupeza", "Cedazo parecido al urupé pero de tejido más ralo."),
    Dictionary(356, "Ururó", "Mono pequeño de color amarillo."),
    Dictionary(357, "Urutaú", "Ave nocturna de canto lúgubre."),
    Dictionary(358, "Usa", "Buey del lado izquierdo del carretón. Voz de mando para que avance."),
    Dictionary(359, "Viudita", "Personaje de ultratumba, representado por una mujer vestida de negro con mantón blanco, cuyo cuerpo está relleno con chala."),
    Dictionary(360, "Yacaré", "Caimán."),
    Dictionary(361, "Yapar", "Añadidura"),
    Dictionary(362, "Yarame", "Piedra roja blanda."),
    Dictionary(363, "Yesca", "Sin dinero."),
    Dictionary(364, "Yeta", "Mala suerte."),
    Dictionary(365, "Yomomo", "Fango."),
    Dictionary(366, "Yoperojobobo", "Variedad de víbora muy venenosa."),
    Dictionary(368, "Zarandajo", "Dícese de la persona chistosa y juguetona."),
    Dictionary(369, "Zocollón", "Acción de empujar bruscamente del cuello a otra persona."),
    )

}