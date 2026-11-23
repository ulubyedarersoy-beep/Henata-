package com.example.data

import com.example.model.PhilosopherBio
import com.example.model.PhilosophicalSchool

object PhilosopherBioCatalog {

    private val bios: Map<String, PhilosopherBio> = mapOf(
        "سقراط" to PhilosopherBio(
            name = "سقراط",
            englishName = "Socrates",
            roleTitle = "مؤسس الفلسفة الأخلاقية الغربية",
            originAndEra = "أثينا • ٤٧٠ – ٣٩٩ ق.م",
            school = PhilosophicalSchool.GREEK,
            summary = "فيلسوف يوناني اشتهر بالمنهج الحواري في طرح الأسئلة للكشف عن التناقضات وبناء الحكمة الأخلاقية."
        ),
        "أفلاطون" to PhilosopherBio(
            name = "أفلاطون",
            englishName = "Plato",
            roleTitle = "مؤسس الأكاديمية في أثينا",
            originAndEra = "أثينا • ٤٢٧ – ٣٤٧ ق.م",
            school = PhilosophicalSchool.GREEK,
            summary = "تلميذ سقراط ومعلّم أرسطو؛ صاغ نظرية المُثُل وبحث في العدالة والمدينة الفاضلة."
        ),
        "أرسطو" to PhilosopherBio(
            name = "أرسطو",
            englishName = "Aristotle",
            roleTitle = "المعلّم الأول في المنطق والأخلاق",
            originAndEra = "إسطة اليونان • ٣٨٤ – ٣٢٢ ق.م",
            school = PhilosophicalSchool.GREEK,
            summary = "موسوعيٌّ أسس علم المنطق وبحث في الوسط الذهبي والفضيلة بوصفها طريق الازدهار الإنساني."
        ),
        "فيثاغورس" to PhilosopherBio(
            name = "فيثاغورس",
            englishName = "Pythagoras",
            roleTitle = "فيلسوف الأعداد والتناغم الكوني",
            originAndEra = "ساموس • ٥٧٠ – ٤٩٥ ق.م",
            school = PhilosophicalSchool.GREEK,
            summary = "فيلسوف ورياضي يوناني رأى في النسب العددية والموسيقى مفتاحاً لفهم نظام الكون."
        ),
        "هيراقليطس" to PhilosopherBio(
            name = "هيراقليطس",
            englishName = "Heraclitus",
            roleTitle = "فيلسوف التغيّر والصيرورة",
            originAndEra = "أفسس • ٥٣٥ – ٤٧٥ ق.م",
            school = PhilosophicalSchool.GREEK,
            summary = "اعتبر التغيّر الدائم جوهر الوجود، وركّز على التوازن الخفي بين الأضداد."
        ),
        "ديموقريطس" to PhilosopherBio(
            name = "ديموقريطس",
            englishName = "Democritus",
            roleTitle = "الفيلسوف الضاحك ومؤسس الذرية",
            originAndEra = "أبديرا • ٤٦٠ – ٣٧٠ ق.م",
            school = PhilosophicalSchool.GREEK,
            summary = "طرح التصور الذري للكون ودعا إلى سكينة النفس والاعتدال في طلب السعادة."
        ),
        "أبيقور" to PhilosopherBio(
            name = "أبيقور",
            englishName = "Epicurus",
            roleTitle = "مؤسس الحديقة الأبيقورية",
            originAndEra = "ساموس وأثينا • ٣٤١ – ٢٧٠ ق.م",
            school = PhilosophicalSchool.GREEK,
            summary = "علّم أن السعادة تتحقق بالبساطة والصداقة والتحرر من الخوف والألم."
        ),
        "زينون الإيلي" to PhilosopherBio(
            name = "زينون الإيلي",
            englishName = "Zeno of Elea",
            roleTitle = "رائد الجدل الفلسفي",
            originAndEra = "إيليا • ٤٩٠ – ٤٣٠ ق.م",
            school = PhilosophicalSchool.GREEK,
            summary = "اشتهر بمفارقاته العقلية التي استهدفت اختبار مفاهيم الحركة والكثرة والمنطق."
        ),
        "إسقراط" to PhilosopherBio(
            name = "إسقراط",
            englishName = "Isocrates",
            roleTitle = "خطيب ومعلّم البلاغة المدنية",
            originAndEra = "أثينا • ٤٣٦ – ٣٣٨ ق.م",
            school = PhilosophicalSchool.GREEK,
            summary = "ربط بين بلاغة التعبير ومسؤولية المواطن في خدمة الصالح العام."
        ),
        "ماركوس أوريليوس" to PhilosopherBio(
            name = "ماركوس أوريليوس",
            englishName = "Marcus Aurelius",
            roleTitle = "الإمبراطور الفيلسوف",
            originAndEra = "روما • ١٢١ – ١٨٠ م",
            school = PhilosophicalSchool.STOIC,
            summary = "إمبراطور روماني دوّن «التأملات» ليذكّر نفسه بالثبات والواجب وضبط الانفعال."
        ),
        "لوسيوس سينيكا" to PhilosopherBio(
            name = "لوسيوس سينيكا",
            englishName = "Lucius Seneca",
            roleTitle = "كاتب ومفكر الرواقية الرومانية",
            originAndEra = "قرطبة وروما • ٤ ق.م – ٦٥ م",
            school = PhilosophicalSchool.STOIC,
            summary = "اهتم بفن استثمار الوقت وتجاوز القلق وممارسة الفضيلة في الحياة اليومية."
        ),
        "إبكتيتوس" to PhilosopherBio(
            name = "إبكتيتوس",
            englishName = "Epictetus",
            roleTitle = "فيلسوف الحرية الداخلية",
            originAndEra = "هيرابوليس • ٥٠ – ١٣٥ م",
            school = PhilosophicalSchool.STOIC,
            summary = "وُلد عبداً وأصبح من أعلام الرواقية؛ فرّق بين ما نتحكم فيه وما يقع خارج إرادتنا."
        ),
        "زينون الرواقي" to PhilosopherBio(
            name = "زينون الرواقي",
            englishName = "Zeno of Citium",
            roleTitle = "مؤسس المدرسة الرواقية",
            originAndEra = "كيتيون وأثينا • ٣٣٤ – ٢٦٢ ق.م",
            school = PhilosophicalSchool.STOIC,
            summary = "أسس الرواق الفلسفي في أثينا ودعا إلى العيش بانسجام مع العقل والطبيعة."
        ),
        "الكندي" to PhilosopherBio(
            name = "الكندي",
            englishName = "Al-Kindi",
            roleTitle = "فيلسوف العرب",
            originAndEra = "البصرة وبغداد • ٨٠١ – ٨٧٣ م",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "أول الفلاسفة العرب المشهورين؛ دعا إلى التماس الحق من كل مصدر صادق والعمل به."
        ),
        "أبو نصر الفارابي" to PhilosopherBio(
            name = "أبو نصر الفارابي",
            englishName = "Al-Farabi",
            roleTitle = "المعلّم الثاني",
            originAndEra = "فاراب وبغداد • ٨٧٢ – ٩٥٠ م",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "وضع أسس الفلسفة السياسية الإسلامية في كتابه «آراء أهل المدينة الفاضلة»."
        ),
        "أبو بكر الرازي" to PhilosopherBio(
            name = "أبو بكر الرازي",
            englishName = "Abu Bakr al-Razi",
            roleTitle = "الطبيب والفيلسوف التجريبي",
            originAndEra = "الري وبغداد • ٨٦٥ – ٩٢٥ م",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "جمع بين المنهج الطبي التجريبي والدفاع عن العقل والتسامح العلمي."
        ),
        "ابن سينا" to PhilosopherBio(
            name = "ابن سينا",
            englishName = "Ibn Sina (Avicenna)",
            roleTitle = "الشيخ الرئيس",
            originAndEra = "بخارى وهمذان • ٩٨٠ – ١٠٣٧ م",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "عالم وفيلسوف موسوعي ألّف «الشفاء» و«القانون في الطب» وبحث في النفس والوجود."
        ),
        "ابن الهيثم" to PhilosopherBio(
            name = "ابن الهيثم",
            englishName = "Ibn al-Haytham",
            roleTitle = "رائد المنهج العلمي التجريبي",
            originAndEra = "البصرة والقاهرة • ٩٦٥ – ١٠٤٠ م",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "رسّخ الشك المنهجي والتجربة والاستقراء أساساً للبحث في البصريات والعلوم."
        ),
        "ابن مسكويه" to PhilosopherBio(
            name = "ابن مسكويه",
            englishName = "Ibn Miskawayh",
            roleTitle = "رائد علم الأخلاق الفلسفي",
            originAndEra = "الري وأصفهان • ٩٣٢ – ١٠٣٠ م",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "صاحب «تهذيب الأخلاق»، ربط بين تربية النفس وبناء الاجتماع الإنساني الراقي."
        ),
        "أبو حيان التوحيدي" to PhilosopherBio(
            name = "أبو حيان التوحيدي",
            englishName = "Abu Hayyan al-Tawhidi",
            roleTitle = "فيلسوف الأدباء وأديب الفلاسفة",
            originAndEra = "بغداد • ٩٢٣ – ١٠٢٣ م",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "امتاز بنظرات نفسية واجتماعية عميقة في «الإمتاع والمؤانسة» و«المقابسات»."
        ),
        "ابن حزم الأندلسي" to PhilosopherBio(
            name = "ابن حزم الأندلسي",
            englishName = "Ibn Hazm of Cordoba",
            roleTitle = "مفكر وفيلسوف الأخلاق والنفس",
            originAndEra = "قرطبة • ٩٩٤ – ١٠٦٤ م",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "حلّل طباع النفس البشرية وطرق مداواة الهموم في كتابه «الأخلاق والسير»."
        ),
        "أبو حامد الغزالي" to PhilosopherBio(
            name = "أبو حامد الغزالي",
            englishName = "Al-Ghazali",
            roleTitle = "حجة الإسلام وباحث اليقين",
            originAndEra = "طوس وبغداد • ١٠٥٨ – ١١١١ م",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "مزج بين النقد الفلسفي والبحث الروحي في «المنقذ من الضلال» و«إحياء علوم الدين»."
        ),
        "ابن طفيل" to PhilosopherBio(
            name = "ابن طفيل",
            englishName = "Ibn Tufail",
            roleTitle = "مؤلف قصة حي بن يقظان",
            originAndEra = "وادي آش ومراكش • ١١٠٥ – ١١٨٥ م",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "أبرز قدرة العقل الفطري والتأمل الحر على بلوغ الحقائق الكبرى."
        ),
        "ابن رشد" to PhilosopherBio(
            name = "ابن رشد",
            englishName = "Ibn Rushd (Averroes)",
            roleTitle = "الشارح الأكبر وفيلسوف قرطبة",
            originAndEra = "قرطبة ومراكش • ١١٢٦ – ١١٩٨ م",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "دافع عن التناغم بين الحكمة والشريعة وكان له أثر بالغ في الفكر الأوروبي."
        ),
        "السهروردي" to PhilosopherBio(
            name = "السهروردي",
            englishName = "Al-Suhrawardi",
            roleTitle = "شيخ الإشراق",
            originAndEra = "سهرورد وحلب • ١١٥٤ – ١١٩١ م",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "أسس حكمة الإشراق التي تجمع بين البرهان العقلي والنور الباطني."
        ),
        "محيي الدين ابن عربي" to PhilosopherBio(
            name = "محيي الدين ابن عربي",
            englishName = "Ibn Arabi",
            roleTitle = "فيلسوف العرفان والوجدان",
            originAndEra = "مرسية ودمشق • ١١٦٥ – ١٢٤٠ م",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "تأمّل في وحدة المعنى والرحمة الإنسانية وسعة القلب."
        ),
        "جلال الدين الرومي" to PhilosopherBio(
            name = "جلال الدين الرومي",
            englishName = "Jalal al-Din Rumi",
            roleTitle = "شاعر الحكمة والمحبة",
            originAndEra = "بلخ وقونية • ١٢٠٧ – ١٢٧٣ م",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "عبّر عن تحوّل الروح بالحب والمعرفة الداخلية في «المثنوي»."
        ),
        "ابن خلدون" to PhilosopherBio(
            name = "ابن خلدون",
            englishName = "Ibn Khaldun",
            roleTitle = "مؤسس علم العمران البشري",
            originAndEra = "تونس والقاهرة • ١٣٣٢ – ١٤٠٦ م",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "وضع قوانين نشوء الدول وانهيارها في «المقدمة»، رابطاً العمران بالعدل."
        ),
        "صدر الدين الشيرازي" to PhilosopherBio(
            name = "صدر الدين الشيرازي",
            englishName = "Mulla Sadra",
            roleTitle = "فيلسوف الحكمة المتعالية",
            originAndEra = "شيراز • ١٥٧١ – ١٦٤٠ م",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "صاحب نظرية «الحركة الجوهرية» التي ترى الوجود في تجدد دائم."
        ),
        "محمد إقبال" to PhilosopherBio(
            name = "محمد إقبال",
            englishName = "Muhammad Iqbal",
            roleTitle = "فيلسوف الذاتية والتجديد",
            originAndEra = "سيالكوت ولاهور • ١٨٧٧ – ١٩٣٨ م",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "دعا إلى إحياء الفكر الإسلامي وبناء الذات الفاعلة الخلّاقة."
        ),
        "إخوان الصفا" to PhilosopherBio(
            name = "إخوان الصفا",
            englishName = "Brethren of Purity",
            roleTitle = "جماعة فكرية موسوعية",
            originAndEra = "البصرة • القرن الرابع الهجري",
            school = PhilosophicalSchool.ISLAMIC,
            summary = "صاغوا رسائل فلسفية جمعت بين العلم والموسيقى والأخلاق والتآخي."
        ),
        "رينيه ديكارت" to PhilosopherBio(
            name = "رينيه ديكارت",
            englishName = "René Descartes",
            roleTitle = "أبو الفلسفة الحديثة",
            originAndEra = "فرنسا • ١٥٩٦ – ١٦٥٠ م",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            summary = "أسس الشك المنهجي واليقين العقلي بقولته الشهيرة: أنا أفكر إذن أنا موجود."
        ),
        "فرانسيس بيكون" to PhilosopherBio(
            name = "فرانسيس بيكون",
            englishName = "Francis Bacon",
            roleTitle = "رائد المنهج الاستقرائي",
            originAndEra = "لندن • ١٥٦١ – ١٦٢٦ م",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            summary = "دعا إلى تحرير العقل من الأوهام وبناء المعرفة على الملاحظة والتجربة."
        ),
        "باروخ سبينوزا" to PhilosopherBio(
            name = "باروخ سبينوزا",
            englishName = "Baruch Spinoza",
            roleTitle = "فيلسوف العقلانية والسكينة",
            originAndEra = "أمستردام • ١٦٣٢ – ١٦٧٧ م",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            summary = "نظر إلى الكون بوصفه نظاماً عقلياً متناغماً ودافع عن حرية الفكر والتسامح."
        ),
        "بليز باسكال" to PhilosopherBio(
            name = "بليز باسكال",
            englishName = "Blaise Pascal",
            roleTitle = "رياضي وفيلسوف الوجدان",
            originAndEra = "باريس • ١٦٢٣ – ١٦٦٢ م",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            summary = "جمع بين العبقرية العلمية والتأمل العميق في عظمة الإنسان ومحدوديته."
        ),
        "جون لوك" to PhilosopherBio(
            name = "جون لوك",
            englishName = "John Locke",
            roleTitle = "رائد التجريبية والحقوق الطبيعية",
            originAndEra = "إنجلترا • ١٦٣٢ – ١٧٠٤ م",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            summary = "دافع عن التسامح الديني وحرية المواطن وحقوقه الفطرية."
        ),
        "مونتسكيو" to PhilosopherBio(
            name = "مونتسكيو",
            englishName = "Montesquieu",
            roleTitle = "فيلسوف القانون وفصل السلطات",
            originAndEra = "فرنسا • ١٦٨٩ – ١٧٥٥ م",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            summary = "حلّل روح القوانين ووضع مبدأ توازن السلطات لمنع الاستبداد."
        ),
        "فولتير" to PhilosopherBio(
            name = "فولتير",
            englishName = "Voltaire",
            roleTitle = "أيقونة التنوير وحرية التعبير",
            originAndEra = "باريس • ١٦٩٤ – ١٧٧٨ م",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            summary = "حارب التعصب ودافع عن حرية الرأي والنقد الساخر المضيء."
        ),
        "جان جاك روسو" to PhilosopherBio(
            name = "جان جاك روسو",
            englishName = "Jean-Jacques Rousseau",
            roleTitle = "فيلسوف العقد الاجتماعي",
            originAndEra = "جنيف وباريس • ١٧١٢ – ١٧٧٨ م",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            summary = "ناقش الحرية الفطرية للإنسان وأهمية التربية الطبيعية والعدالة."
        ),
        "ديفيد هيوم" to PhilosopherBio(
            name = "ديفيد هيوم",
            englishName = "David Hume",
            roleTitle = "رائد الشك التجريبي",
            originAndEra = "إدنبرة • ١٧١١ – ١٧٧٦ م",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            summary = "أخضع السببية والمعرفة لاختبار التجربة المباشرة والحس السليم."
        ),
        "إيمانويل كانط" to PhilosopherBio(
            name = "إيمانويل كانط",
            englishName = "Immanuel Kant",
            roleTitle = "فيلسوف النقد والواجب الأخلاقي",
            originAndEra = "كونيغسبرغ • ١٧٢٤ – ١٨٠٤ م",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            summary = "صاغ شعار التنوير «تجرّأ على استخدام عقلك» وأسس أخلاق الكرامة والواجب."
        ),
        "ميشيل دي مونتين" to PhilosopherBio(
            name = "ميشيل دي مونتين",
            englishName = "Michel de Montaigne",
            roleTitle = "مبتكر فن المقالة التأملية",
            originAndEra = "فرنسا • ١٥٣٣ – ١٥٩٢ م",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            summary = "كتب بتواضع وإنسانية عن التسامح وفهم الذات وتقلبات الحياة."
        ),
        "جون ستيوارت مل" to PhilosopherBio(
            name = "جون ستيوارت مل",
            englishName = "John Stuart Mill",
            roleTitle = "فيلسوف الحرية الفردية",
            originAndEra = "لندن • ١٨٠٦ – ١٨٧٣ م",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            summary = "دافع عن حرية التعبير وتنوع الآراء بوصفهما شرطين للتقدم الإنساني."
        ),
        "برتراند راسل" to PhilosopherBio(
            name = "برتراند راسل",
            englishName = "Bertrand Russell",
            roleTitle = "فيلسوف المنطق والسلام",
            originAndEra = "بريطانيا • ١٨٧٢ – ١٩٧٠ م",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            summary = "حاز نوبل للآداب؛ دعا إلى التفكير العلمي المتواضع والبحث عن السعادة الهادئة."
        ),
        "كارل بوبر" to PhilosopherBio(
            name = "كارل بوبر",
            englishName = "Karl Popper",
            roleTitle = "فيلسوف العلم والمجتمع المفتوح",
            originAndEra = "فيينا ولندن • ١٩٠٢ – ١٩٩٤ م",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            summary = "اشترط القابلية للتخطئة في العلم ودافع عن المجتمع المفتوح القائم على النقد."
        ),
        "أرتور شوبنهاور" to PhilosopherBio(
            name = "أرتور شوبنهاور",
            englishName = "Arthur Schopenhauer",
            roleTitle = "فيلسوف الإرادة والفن",
            originAndEra = "فرانكفورت • ١٧٨٨ – ١٨٦٠ م",
            school = PhilosophicalSchool.EXISTENTIAL,
            summary = "تأمّل في طبيعة الرغبة والمعاناة، ورأى في الفن والرحمة ملجأً للروح."
        ),
        "سورين كيركغور" to PhilosopherBio(
            name = "سورين كيركغور",
            englishName = "Søren Kierkegaard",
            roleTitle = "رائد الفلسفة الوجودية",
            originAndEra = "كوبنهاغن • ١٨١٣ – ١٨٥٥ م",
            school = PhilosophicalSchool.EXISTENTIAL,
            summary = "ركّز على الاختيار الفردي والصدق الباطني ومسؤولية الإنسان أمام ذاته."
        ),
        "فريدريك نيتشه" to PhilosopherBio(
            name = "فريدريك نيتشه",
            englishName = "Friedrich Nietzsche",
            roleTitle = "فيلسوف القيم وتجاوز الذات",
            originAndEra = "ألمانيا • ١٨٤٤ – ١٩٠٠ م",
            school = PhilosophicalSchool.EXISTENTIAL,
            summary = "دعا الإنسان إلى خلق معناه الخاص وتقبّل الحياة بكل تحدياتها."
        ),
        "رالف والدو إيمرسون" to PhilosopherBio(
            name = "رالف والدو إيمرسون",
            englishName = "Ralph Waldo Emerson",
            roleTitle = "فيلسوف الاعتماد على الذات",
            originAndEra = "بوسطن • ١٨٠٣ – ١٨٨٢ م",
            school = PhilosophicalSchool.EXISTENTIAL,
            summary = "احتفى بالاستقلال الفكري والانسجام بين الإنسان والطبيعة."
        ),
        "مارتن بوبر" to PhilosopherBio(
            name = "مارتن بوبر",
            englishName = "Martin Buber",
            roleTitle = "فيلسوف الحوار والعلاقة",
            originAndEra = "فيينا • ١٨٧٨ – ١٩٦٥ م",
            school = PhilosophicalSchool.EXISTENTIAL,
            summary = "ميّز بين العلاقة الشيئية واللقاء الإنساني الأصيل القائم على الحضور."
        ),
        "كارل ياسبرز" to PhilosopherBio(
            name = "كارل ياسبرز",
            englishName = "Karl Jaspers",
            roleTitle = "فيلسوف التواصل الوجودي",
            originAndEra = "ألمانيا وسويسرا • ١٨٨٣ – ١٩٦٩ م",
            school = PhilosophicalSchool.EXISTENTIAL,
            summary = "رأى أن السؤال الفلسفي يوقظ حرية الإنسان في المواقف المصيرية."
        ),
        "مارتن هايدغر" to PhilosopherBio(
            name = "مارتن هايدغر",
            englishName = "Martin Heidegger",
            roleTitle = "فيلسوف الوجود والزمان",
            originAndEra = "ألمانيا • ١٨٨٩ – ١٩٧٦ م",
            school = PhilosophicalSchool.EXISTENTIAL,
            summary = "بحث في معنى الكينونة الأصيلة وعلاقة الإنسان باللغة والزمن."
        ),
        "غابرييل مارسيل" to PhilosopherBio(
            name = "غابرييل مارسيل",
            englishName = "Gabriel Marcel",
            roleTitle = "فيلسوف الأمل والوجود",
            originAndEra = "باريس • ١٨٨٩ – ١٩٧٣ م",
            school = PhilosophicalSchool.EXISTENTIAL,
            summary = "فرّق بين الامتلاك المادي والكينونة الروحية القائمة على الرجاء."
        ),
        "جان بول سارتر" to PhilosopherBio(
            name = "جان بول سارتر",
            englishName = "Jean-Paul Sartre",
            roleTitle = "منظّر الوجودية والحرية",
            originAndEra = "باريس • ١٩٠٥ – ١٩٨٠ م",
            school = PhilosophicalSchool.EXISTENTIAL,
            summary = "أكد أن الإنسان يخلق ماهيته عبر أفعاله الحرة والتزامه الأخلاقي."
        ),
        "سيمون دي بوفوار" to PhilosopherBio(
            name = "سيمون دي بوفوار",
            englishName = "Simone de Beauvoir",
            roleTitle = "فيلسوفة الحرية والمسؤولية",
            originAndEra = "باريس • ١٩٠٨ – ١٩٨٦ م",
            school = PhilosophicalSchool.EXISTENTIAL,
            summary = "ربطت حرية الفرد بالاعتراف المتبادل بحرية الآخرين."
        ),
        "سيمون فايل" to PhilosopherBio(
            name = "سيمون فايل",
            englishName = "Simone Weil",
            roleTitle = "فيلسوفة الانتباه والرحمة",
            originAndEra = "باريس • ١٩٠٩ – ١٩٤٣ م",
            school = PhilosophicalSchool.EXISTENTIAL,
            summary = "اعتبرت الانتباه الصادق لمعاناة الآخرين أسمى أشكال العدالة والمحبة."
        ),
        "ألبير كامو" to PhilosopherBio(
            name = "ألبير كامو",
            englishName = "Albert Camus",
            roleTitle = "أديب وفيلسوف التمرّد الإنساني",
            originAndEra = "الجزائر وباريس • ١٩١٣ – ١٩٦٠ م",
            school = PhilosophicalSchool.EXISTENTIAL,
            summary = "بحث في مواجهة العبث بالصمود والجمال والتضامن البشري."
        ),
        "حنة أرندت" to PhilosopherBio(
            name = "حنة أرندت",
            englishName = "Hannah Arendt",
            roleTitle = "فيلسوفة التفكير والفعل السياسي",
            originAndEra = "ألمانيا ونيويورك • ١٩٠٦ – ١٩٧٥ م",
            school = PhilosophicalSchool.EXISTENTIAL,
            summary = "نبهت إلى خطورة الكسل الفكري وأهمية الحكم الأخلاقي المستقل."
        ),
        "كونفوشيوس" to PhilosopherBio(
            name = "كونفوشيوس",
            englishName = "Confucius",
            roleTitle = "حكيم الصين ومعلّم الأخلاق",
            originAndEra = "الصين • ٥٥١ – ٤٧٩ ق.م",
            school = PhilosophicalSchool.ASIAN,
            summary = "ركّز على البر والعدالة والتعلّم المستمر وتهذيب الأسرة والمجتمع."
        ),
        "لاوتزه" to PhilosopherBio(
            name = "لاوتزه",
            englishName = "Laozi",
            roleTitle = "مؤسس الفلسفة الطاوية",
            originAndEra = "الصين • القرن السادس ق.م",
            school = PhilosophicalSchool.ASIAN,
            summary = "مؤلف «تاو تي تشينغ»؛ دعا إلى البساطة واللين والانسجام مع إيقاع الطبيعة."
        ),
        "جوانغ زي" to PhilosopherBio(
            name = "جوانغ زي",
            englishName = "Zhuangzi",
            roleTitle = "شاعر الطاوية وفيلسوف الحرية",
            originAndEra = "الصين • ٣٦٩ – ٢٨٦ ق.م",
            school = PhilosophicalSchool.ASIAN,
            summary = "استخدم القصص الرمزية للتحرر من القيود الشكلية وتوسيع آفاق الوعي."
        ),
        "بوذا" to PhilosopherBio(
            name = "بوذا",
            englishName = "Buddha (Siddhartha Gautama)",
            roleTitle = "سيدهارثا غوتاما — المعلّم المستنير",
            originAndEra = "الهند القديمة • ٥٦٣ – ٤٨٣ ق.م",
            school = PhilosophicalSchool.ASIAN,
            summary = "دعا إلى اليقظة الذهنية والرحمة وفهم جذور المعاناة لتجاوزها."
        ),
        "منشيوس" to PhilosopherBio(
            name = "منشيوس",
            englishName = "Mencius",
            roleTitle = "الحكيم الثاني في الكونفوشية",
            originAndEra = "الصين • ٣٧٢ – ٢٨٩ ق.م",
            school = PhilosophicalSchool.ASIAN,
            summary = "آمن بالخير الفطري في الطبيعة البشرية وبضرورة رعايته بالعدل."
        ),
        "سون تزو" to PhilosopherBio(
            name = "سون تزو",
            englishName = "Sun Tzu",
            roleTitle = "فيلسوف الاستراتيجية والحسم السلمي",
            originAndEra = "الصين • ٥٤٤ – ٤٩٦ ق.م",
            school = PhilosophicalSchool.ASIAN,
            summary = "صاحب «فن الحرب»، جعل التخطيط ومعرفة الذات والخصم طريق النجاح دون صدام."
        ),
        "موزي" to PhilosopherBio(
            name = "موزي",
            englishName = "Mozi",
            roleTitle = "فيلسوف المحبة الشاملة",
            originAndEra = "الصين • ٤٧٠ – ٣٩١ ق.م",
            school = PhilosophicalSchool.ASIAN,
            summary = "دعا إلى المحبة المتساوية للجميع ونبذ الحروب والإسراف."
        ),
        "شون زي" to PhilosopherBio(
            name = "شون زي",
            englishName = "Xunzi",
            roleTitle = "فيلسوف التهذيب والعقل",
            originAndEra = "الصين • ٣١٠ – ٢٣٥ ق.م",
            school = PhilosophicalSchool.ASIAN,
            summary = "شدد على دور التعليم والانضباط في تهذيب الطباع وبناء الحضارة."
        ),
        "ناغارجونا" to PhilosopherBio(
            name = "ناغارجونا",
            englishName = "Nagarjuna",
            roleTitle = "فيلسوف الطريق الأوسط",
            originAndEra = "الهند • ١٥٠ – ٢٥٠ م",
            school = PhilosophicalSchool.ASIAN,
            summary = "عمّق مفهوم الترابط المتبادل بين كل الظواهر وتجنّب الأحكام المتطرفة."
        ),
        "دوغن" to PhilosopherBio(
            name = "دوغن",
            englishName = "Dōgen",
            roleTitle = "فيلسوف الزن واللحظة الحاضرة",
            originAndEra = "اليابان • ١٢٠٠ – ١٢٥٣ م",
            school = PhilosophicalSchool.ASIAN,
            summary = "علّم أن الحضور الكامل في كل فعل يومي هو جوهر اليقظة الروحية."
        ),
        "مياموتو موساشي" to PhilosopherBio(
            name = "مياموتو موساشي",
            englishName = "Miyamoto Musashi",
            roleTitle = "حكيم الانضباط والهدوء",
            originAndEra = "اليابان • ١٥٨٤ – ١٦٤٥ م",
            school = PhilosophicalSchool.ASIAN,
            summary = "ربط بين إتقان الحرفة وصفاء الذهن والعيش بوضوح دون تشتت."
        ),
        "كيتارو نيشيدا" to PhilosopherBio(
            name = "كيتارو نيشيدا",
            englishName = "Kitarō Nishida",
            roleTitle = "مؤسس مدرسة كيوتو الفلسفية",
            originAndEra = "اليابان • ١٨٧٠ – ١٩٤٥ م",
            school = PhilosophicalSchool.ASIAN,
            summary = "أقام جسراً فلسفياً بين الفكر الشرقي التأملي والفلسفة الأوروبية الحديثة."
        ),
        "رابندراناث طاغور" to PhilosopherBio(
            name = "رابندراناث طاغور",
            englishName = "Rabindranath Tagore",
            roleTitle = "شاعر وفيلسوف الإنسانية",
            originAndEra = "الهند • ١٨٦١ – ١٩٤١ م",
            school = PhilosophicalSchool.ASIAN,
            summary = "حاز نوبل للآداب؛ تغنّى بالسلام والجمال والتواصل الحي مع الطبيعة."
        ),
        "سوامي فيفيكاناندا" to PhilosopherBio(
            name = "سوامي فيفيكاناندا",
            englishName = "Swami Vivekananda",
            roleTitle = "فيلسوف القوة الروحية والخدمة",
            originAndEra = "الهند • ١٨٦٣ – ١٩٠٢ م",
            school = PhilosophicalSchool.ASIAN,
            summary = "دعا إلى إيقاظ الثقة الداخلية وخدمة الإنسان بوصفها أسمى حكمة."
        )
    )

    fun getBio(philosopherName: String): PhilosopherBio {
        return bios[philosopherName] ?: PhilosopherBio(
            name = philosopherName,
            englishName = philosopherName,
            roleTitle = "فيلسوف ومفكر",
            originAndEra = "التراث الفلسفي العالمي",
            school = PhilosophicalSchool.ALL,
            summary = "أحد المفكرين الذين أسهموا في إثراء الفكر الإنساني بالبحث والتأمل."
        )
    }
}
