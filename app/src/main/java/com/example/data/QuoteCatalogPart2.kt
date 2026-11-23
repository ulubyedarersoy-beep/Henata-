package com.example.data

import com.example.model.PhilosophicalQuote
import com.example.model.PhilosophicalSchool

internal object QuoteCatalogPart2 {
    val quotes: List<PhilosophicalQuote> = listOf(
        PhilosophicalQuote(
            id = 51,
            text = "من ضيّعَ الحزمَ ندم، ومن التمسَ العقلَ قبلَ الغضبِ نجَا من عثراتِ اللسان.",
            englishText = "Whoever neglects prudence meets regret, and whoever seeks reason before anger is spared slips of the tongue.",
            philosopher = "ابن حزم الأندلسي",
            school = PhilosophicalSchool.ISLAMIC,
            era = "٩٩٤ – ١٠٦٤ م",
            reflection = "طرد الهمّ والتريث في المواقف الصعبة من أصول السكينة النفسية."
        ),
        PhilosophicalQuote(
            id = 52,
            text = "السماءُ المرصّعةُ بالنجومِ فوقي، والقانونُ الأخلاقيُّ في داخلي؛ هما أعظمُ ما يملأُ النفسَ إجلالاً.",
            englishText = "The starry heavens above me and the moral law within me fill the soul with ever-deepening awe.",
            philosopher = "إيمانويل كانط",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٧٢٤ – ١٨٠٤ م",
            reflection = "عظمة الكون الخارجي تتقابل مع عظمة الضمير الحي في قلب الإنسان."
        ),
        PhilosophicalQuote(
            id = 53,
            text = "الغضبُ حمضٌ يأكلُ الوعاءَ الذي يُحفظُ فيه أكثرَ ممّا يضرُّ الشيءَ الذي يُسكبُ عليه.",
            englishText = "Anger is an acid that corrodes the vessel holding it far more than anything upon which it is poured.",
            philosopher = "لوسيوس سينيكا",
            school = PhilosophicalSchool.STOIC,
            era = "٤ ق.م – ٦٥ م",
            reflection = "الهدوء عند الاستفزاز يحفظ صحة القلب وصفاء القرار."
        ),
        PhilosophicalQuote(
            id = 54,
            text = "لا يقدرُ الإنسانُ على تغييرِ اتّجاهِ الريح، لكنّه يستطيعُ دائماً أن يُعدّلَ شراعَه ليبلغَ الميناء.",
            englishText = "We cannot redirect the wind, yet we can always adjust our sails to reach the harbor.",
            philosopher = "أرسطو",
            school = PhilosophicalSchool.GREEK,
            era = "٣٨٤ – ٣٢٢ ق.م",
            reflection = "المرونة الحكيمة تجمع بين وضوح الهدف والتكيّف مع المتغيرات."
        ),
        PhilosophicalQuote(
            id = 55,
            text = "كلُّ إنسانٍ يرى حدودَ مجالِ رؤيتِه الشخصيِّ على أنّها حدودُ العالمِ بأسرِه.",
            englishText = "Every person takes the limits of their own field of vision for the limits of the entire world.",
            philosopher = "أرتور شوبنهاور",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٧٨٨ – ١٨٦٠ م",
            reflection = "توسيع المعرفة ومخالطة الثقافات يكسران وهم النظرة الضيقة."
        ),
        PhilosophicalQuote(
            id = 56,
            text = "الهمّةُ العاليةُ لا تقفُ عند قشورِ الأشياء، بل تنفذُ إلى لبابِها ومعانيها العميقة.",
            englishText = "High aspiration does not linger on outer husks; it pierces straight to the kernel and deepest meaning.",
            philosopher = "السهروردي",
            school = PhilosophicalSchool.ISLAMIC,
            era = "١١٥٤ – ١١٩١ م",
            reflection = "البصيرة النقدية تتجاوز الظاهر السطحي إلى الجوهر الثابت."
        ),
        PhilosophicalQuote(
            id = 57,
            text = "لا تخفْ من السيرِ ببطءٍ نحو الحقيقة، بل خفْ من الوقوفِ في مكانِك بلا تساؤل.",
            englishText = "Fear not walking slowly toward truth; fear standing still without ever asking why.",
            philosopher = "سقراط",
            school = PhilosophicalSchool.GREEK,
            era = "٤٧٠ – ٣٩٩ ق.م",
            reflection = "التدرّج المستمر في طلب الفهم أعمق أثراً من الاندفاع المؤقت."
        ),
        PhilosophicalQuote(
            id = 58,
            text = "إذا كان لا بدَّ للروحِ أن تزهر، فعليها أن تمرَّ بفصولِ التغييرِ دون خشيةِ الذبول.",
            englishText = "If the spirit is to blossom, it must pass through seasons of change without fearing the autumn leaf.",
            philosopher = "ماركوس أوريليوس",
            school = PhilosophicalSchool.STOIC,
            era = "١٢١ – ١٨٠ م",
            reflection = "التحوّل قانون الطبيعة؛ والتسليم الحكيم به يفتح باب التجدد."
        ),
        PhilosophicalQuote(
            id = 59,
            text = "السعادةُ أن يتّفقَ ما تُفكّرُ فيه، مع ما تقولُه، مع ما تفعلُه في واقعِ حياتِك.",
            englishText = "Happiness is harmony between what you think, what you say, and what you practice in daily life.",
            philosopher = "ميشيل دي مونتين",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٥٣٣ – ١٥٩٢ م",
            reflection = "التناغم بين الفكر والقول والعمل يزيل التمزق الداخلي."
        ),
        PhilosophicalQuote(
            id = 60,
            text = "في نهايةِ كلِّ رحلةٍ فلسفية، نكتشفُ أنَّ السؤالَ الصادقَ أثمنُ من الجوابِ المتعجّل.",
            englishText = "At the end of every philosophical journey, we discover an honest question is worth more than a hasty answer.",
            philosopher = "كارل ياسبرز",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٨٨٣ – ١٩٦٩ م",
            reflection = "الفلسفة رحلة بحث دائمة تبقي العقل متيقظاً ومفتوحاً على الدهشة."
        ),
        PhilosophicalQuote(
            id = 61,
            text = "أعظمُ انتصارٍ يحقّقُه الإنسانُ هو انتصارُه على نفسِه الأمّارةِ بالهوى والانفعال.",
            englishText = "The noblest victory a human being can win is mastery over impulsive passion and whim.",
            philosopher = "أفلاطون",
            school = PhilosophicalSchool.GREEK,
            era = "٤٢٧ – ٣٤٧ ق.م",
            reflection = "ضبط النفس أصل كل قيادة رشيدة للذات وللآخرين."
        ),
        PhilosophicalQuote(
            id = 62,
            text = "السكينةُ هي أنْ تتركَ الماضي للماضي، والمستقبلَ للحكمة، وأنْ تُحسنَ تدبيرَ يومِك الحاضر.",
            englishText = "Serenity is leaving the past to the past, the future to wisdom, and stewarding today with care.",
            philosopher = "ماركوس أوريليوس",
            school = PhilosophicalSchool.STOIC,
            era = "١٢١ – ١٨٠ م",
            reflection = "إغلاق أبواب الأمس والغد يركّز القوة العقلية في الفعل المتاح الآن."
        ),
        PhilosophicalQuote(
            id = 63,
            text = "إنّ العقلَ نورٌ يفرقُ به الإنسانُ بين الحقِّ والباطل، فإذا أطفأه التعصّبُ عميَتِ البصيرة.",
            englishText = "Reason is a light distinguishing truth from falsehood; when fanaticism extinguishes it, insight grows blind.",
            philosopher = "ابن طفيل",
            school = PhilosophicalSchool.ISLAMIC,
            era = "١١٠٥ – ١١٨٥ م",
            reflection = "الفطرة السليمة والتأمل الحر يقودان إلى الحقائق الكبرى."
        ),
        PhilosophicalQuote(
            id = 64,
            text = "كلُّ الأشياءِ الجليلةِ صعبةُ المنالِ بقدرِ ما هي نادرةٌ ورفيعةُ القدر.",
            englishText = "All things truly noble are as difficult to attain as they are rare and precious.",
            philosopher = "باروخ سبينوزا",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٦٣٢ – ١٦٧٧ م",
            reflection = "البلوغ إلى الحكمة والحرية الداخلية يتطلب صبراً ومثابرة."
        ),
        PhilosophicalQuote(
            id = 65,
            text = "القلقُ هو دُوارُ الحريةِ حين تدركُ النفسُ اتّساعَ الممكناتِ أمامَ اختياراتِها.",
            englishText = "Anxiety is the dizziness of freedom when the soul beholds the vast expanse of its choices.",
            philosopher = "سورين كيركغور",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٨١٣ – ١٨٥٥ م",
            reflection = "الشعور بالرهبة أمام القرار علامة على وعي الإنسان بمسؤوليته."
        ),
        PhilosophicalQuote(
            id = 66,
            text = "لا شيءَ يبقى على حالِه سوى قانونِ التغيّرِ نفسِه؛ فأنتَ لا تخطو في النهرِ ذاتِه مرّتَين.",
            englishText = "Nothing endures unchanged save the law of change itself; you never step into the same river twice.",
            philosopher = "هيراقليطس",
            school = PhilosophicalSchool.GREEK,
            era = "٥٣٥ – ٤٧٥ ق.م",
            reflection = "تقبّل الصيرورة الدائمة يعلمنا عدم التجمّد عند لحظة عابرة."
        ),
        PhilosophicalQuote(
            id = 67,
            text = "لنا أذنانِ وفمٌ واحدٌ؛ كي نُصغيَ ضعفَ ما نتكلّمَ، ونفهمَ قبلَ أنْ نُجيب.",
            englishText = "We have two ears and one mouth so that we may listen twice as much as we speak.",
            philosopher = "زينون الرواقي",
            school = PhilosophicalSchool.STOIC,
            era = "٣٣٤ – ٢٦٢ ق.م",
            reflection = "حسن الاستماع بوابة الفهم العميق والحوار المثمر."
        ),
        PhilosophicalQuote(
            id = 68,
            text = "من لم يذقْ لذةَ البحثِ عن الحقيقة، قضى عمرَه أسيراً لتقليدٍ لم يتحقّقْ من أصلِه.",
            englishText = "Whoever never tastes the joy of seeking truth spends life captive to unexamined imitation.",
            philosopher = "أبو حامد الغزالي",
            school = PhilosophicalSchool.ISLAMIC,
            era = "١٠٥٨ – ١١١١ م",
            reflection = "التحقق الشخصي يرفع الإيمان والمعرفة من مستوى العادة إلى اليقين."
        ),
        PhilosophicalQuote(
            id = 69,
            text = "قد أختلفُ معكَ في الرأي، لكنّني مستعدٌّ أنْ أدافعَ عن حقّك في التعبيرِ عنه.",
            englishText = "I may disagree with your opinion, yet I stand ready to defend your right to express it.",
            philosopher = "فولتير",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٦٩٤ – ١٧٧٨ م",
            reflection = "حرية الفكر لا تكتمل إلا بحماية حق المخالف في الكلام."
        ),
        PhilosophicalQuote(
            id = 70,
            text = "المرءُ مسؤولٌ عمّا يصنعُه بما صنعتْه الظروفُ فيه؛ فالاختيارُ يبدأُ بعدَ الأثر.",
            englishText = "A person is responsible for what they make of what circumstances have made of them.",
            philosopher = "جان بول سارتر",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٩٠٥ – ١٩٨٠ م",
            reflection = "القيود الخارجية لا تلغي قدرتنا على إعادة صياغة استجابتنا."
        ),
        PhilosophicalQuote(
            id = 71,
            text = "الكلامُ مقياسُ العقل؛ فإمّا أنْ يكشفَ عن سدادِ الرأيِ أو يُظهرَ ضيقَ الأفق.",
            englishText = "Speech is the mirror of the mind; it reveals either soundness of judgment or narrowness of outlook.",
            philosopher = "ديموقريطس",
            school = PhilosophicalSchool.GREEK,
            era = "٤٦٠ – ٣٧٠ ق.م",
            reflection = "اختيار الكلمات يعكس النظام الداخلي للأفكار."
        ),
        PhilosophicalQuote(
            id = 72,
            text = "ليس القويُّ مَن هزمَ الناس، بل مَن كبحَ جماحَ شهواتِه ولم يبعْ كرامتَه لرغبةٍ زائلة.",
            englishText = "Strong is not the conqueror of crowds, but one who masters appetite and never trades dignity for fleeting desire.",
            philosopher = "إبكتيتوس",
            school = PhilosophicalSchool.STOIC,
            era = "٥٠ – ١٣٥ م",
            reflection = "السيادة على النفس هي أصدق أشكال الحرية."
        ),
        PhilosophicalQuote(
            id = 73,
            text = "الجهلُ أشدُّ ظلماً للروحِ من الفقرِ للجسد؛ فالعلمُ يُحيي القلوبَ الميتةَ بنورِ الفهم.",
            englishText = "Ignorance darkens the spirit harsher than poverty weighs on the body; knowledge revives hearts with light.",
            philosopher = "إخوان الصفا",
            school = PhilosophicalSchool.ISLAMIC,
            era = "القرن الرابع الهجري",
            reflection = "المعرفة غذاء العقل والروح الذي لا ينفد."
        ),
        PhilosophicalQuote(
            id = 74,
            text = "التجربةُ هي المعلّمُ الأوّلُ للعقل، ومن دونِها تبقى الأفكارُ صوراً باهتةً في الفراغ.",
            englishText = "Experience is the primary teacher of the mind; without it, ideas remain faint shadows in empty air.",
            philosopher = "ديفيد هيوم",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٧١١ – ١٧٧٦ م",
            reflection = "اختبار الأفكار في الواقع يحمي الفكر من الأوهام المجردة."
        ),
        PhilosophicalQuote(
            id = 75,
            text = "ما يُسمّيهِ الناسُ قدراً، هو في كثيرٍ من الأحيانِ حصيلةُ قراراتٍ متكرّرةٍ لم يلتفتوا إليها.",
            englishText = "What people call fate is often the quiet sum of repeated choices made without reflection.",
            philosopher = "أرتور شوبنهاور",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٧٨٨ – ١٨٦٠ م",
            reflection = "العادات اليومية الصغيرة ترسم ملامح المصير على المدى الطويل."
        ),
        PhilosophicalQuote(
            id = 76,
            text = "طاعةُ القوانينِ الصالحةِ والضميرِ اليقظِ هي التي تميّزُ المواطنَ الحرَّ عن العبدِ التائه.",
            englishText = "Obedience to just laws and an awake conscience distinguishes a free citizen from a drifting captive.",
            philosopher = "أرسطو",
            school = PhilosophicalSchool.GREEK,
            era = "٣٨٤ – ٣٢٢ ق.م",
            reflection = "الحرية المسؤولة تزدهر في كنف النظام العادل."
        ),
        PhilosophicalQuote(
            id = 77,
            text = "الرخاءُ يختبرُ حكمةَ الإنسانِ كما يختبرُ البلاءُ صبرَه؛ وكلاهما يحتاجُ إلى نفسٍ متّزنة.",
            englishText = "Prosperity tests our wisdom just as adversity tests our endurance; both demand an even soul.",
            philosopher = "لوسيوس سينيكا",
            school = PhilosophicalSchool.STOIC,
            era = "٤ ق.م – ٦٥ م",
            reflection = "الثبات النفسي لا يتبدّل بتبدّل الأحوال بين السعة والضيق."
        ),
        PhilosophicalQuote(
            id = 78,
            text = "إنّ شرفَ الصناعاتِ والعلومِ بقدرِ ما تُثمرُه من نفعٍ للناسِ وارتقاءٍ بالعقل.",
            englishText = "The honor of crafts and sciences lies in the benefit they yield for humanity and the elevation of reason.",
            philosopher = "ابن خلدون",
            school = PhilosophicalSchool.ISLAMIC,
            era = "١٣٣٢ – ١٤٠٦ م",
            reflection = "العلم الحقيقي يقترن بعمران الأرض وخدمة الإنسان."
        ),
        PhilosophicalQuote(
            id = 79,
            text = "الشكُّ في المسلماتِ الموروثةِ هو الخطوةُ الأولى نحو كلِّ اكتشافٍ إنسانيٍّ عظيم.",
            englishText = "Questioning inherited dogmas is the first step toward every great human discovery.",
            philosopher = "فولتير",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٦٩٤ – ١٧٧٨ م",
            reflection = "الجرأة على السؤال تفتح أبواباً كانت مغلقة بالاعتياد."
        ),
        PhilosophicalQuote(
            id = 80,
            text = "أنْ تعيشَ حياتَك بصدقٍ مع ذاتك، خيرٌ من أنْ تنالَ رضا العالمِ وأنتَ غريبٌ عن روحك.",
            englishText = "To live honestly with yourself is far better than winning the world's applause as a stranger to your own soul.",
            philosopher = "سيمون دي بوفوار",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٩٠٨ – ١٩٨٦ م",
            reflection = "الأصالة الوجودية تبدأ بالوفاء لقيمك الداخلية."
        ),
        PhilosophicalQuote(
            id = 81,
            text = "الجمالُ في النفسِ يسبقُ الجمالَ في الصورة؛ فالأخلاقُ الحسنةُ تُزيّنُ كلَّ ما تمسُّه.",
            englishText = "Beauty of soul precedes beauty of form; noble character adorns everything it touches.",
            philosopher = "سقراط",
            school = PhilosophicalSchool.GREEK,
            era = "٤٧٠ – ٣٩٩ ق.م",
            reflection = "الجمال الأخلاقي دائم لا يبلى بمرور السنين."
        ),
        PhilosophicalQuote(
            id = 82,
            text = "لا تطلبْ أنْ تجريَ الأمورُ كما تهوى، بلِ ارْضَ بأنْ تجريَ كما تجري، تجدِ الطمأنينة.",
            englishText = "Do not demand that events happen as you wish; wish them to happen as they do, and peace will follow.",
            philosopher = "إبكتيتوس",
            school = PhilosophicalSchool.STOIC,
            era = "٥٠ – ١٣٥ م",
            reflection = "المرونة مع الواقع تمنع الاستنزاف النفسي."
        ),
        PhilosophicalQuote(
            id = 83,
            text = "الكمالُ الإنسانيُّ يبدأُ بتصحيحِ التصوّر، ويكتملُ بتهذيبِ الإرادةِ والعمل.",
            englishText = "Human perfection begins with clarifying understanding and matures through refining will and action.",
            philosopher = "أبو نصر الفارابي",
            school = PhilosophicalSchool.ISLAMIC,
            era = "٨٧٢ – ٩٥٠ م",
            reflection = "الفكر الصحيح لا يثمر دون إرادة تُترجمه إلى سلوك."
        ),
        PhilosophicalQuote(
            id = 84,
            text = "الحكومةُ الصالحةُ هي التي تحمي حريةَ المواطنِ ولا تتدخّلُ في ضميرِه وعقلِه.",
            englishText = "Good government protects the liberty of citizens without trespassing upon their conscience and mind.",
            philosopher = "جون لوك",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٦٣٢ – ١٧٠٤ م",
            reflection = "حفظ الكرامة والحقوق الفردية أساس الشرعية المدنية."
        ),
        PhilosophicalQuote(
            id = 85,
            text = "لا يأسَ مع الحياةِ لمن أدركَ أنَّ المعنى لا يُعثرُ عليه جاهزاً، بل يُبنى بالعمل.",
            englishText = "Despair yields to life when one realizes meaning is not found ready-made, but built through action.",
            philosopher = "ألبير كامو",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٩١٣ – ١٩٦٠ م",
            reflection = "العمل الإبداعي والتضامن الإنساني يبددان وحشة العبث."
        ),
        PhilosophicalQuote(
            id = 86,
            text = "البدايةُ هي نصفُ العملِ كلِّه؛ فمن أحسنَ الخطوةَ الأولى هانَ عليه ما بعدها.",
            englishText = "The beginning is half of the entire work; whoever takes the first step well eases all that follows.",
            philosopher = "أفلاطون",
            school = PhilosophicalSchool.GREEK,
            era = "٤٢٧ – ٣٤٧ ق.م",
            reflection = "كسر جمود البداية أصعب عقبة في طريق الإنجاز."
        ),
        PhilosophicalQuote(
            id = 87,
            text = "كثيراً ما نُؤذي أنفسَنا بأفكارِنا أكثرَ ممّا يقدرُ أيُّ عدوٍّ أنْ يُؤذيَنا به.",
            englishText = "Far more often we wound ourselves with our own thoughts than any external enemy ever could.",
            philosopher = "ماركوس أوريليوس",
            school = PhilosophicalSchool.STOIC,
            era = "١٢١ – ١٨٠ م",
            reflection = "تصفية الذهن من الأحقاد والوساوس حمايةٌ حقيقية للذات."
        ),
        PhilosophicalQuote(
            id = 88,
            text = "التجربةُ والمشاهدةُ هما ميزانُ العلمِ الصحيح، لا الاكتفاءُ بترديدِ أقوالِ السابقين.",
            englishText = "Experiment and observation are the true scales of science, not merely repeating the claims of predecessors.",
            philosopher = "ابن الهيثم",
            school = PhilosophicalSchool.ISLAMIC,
            era = "٩٦٥ – ١٠٤٠ م",
            reflection = "النقد العلمي القائم على البرهان والتجربة أساس التقدم المعرفي."
        ),
        PhilosophicalQuote(
            id = 89,
            text = "العاداتُ في البدايةِ خيوطٌ رفيعة، ثمّ تصبحُ مع التكرارِ قيوداً يصعبُ كسرُها.",
            englishText = "Habits begin as thin threads, yet with repetition grow into chains hard to break.",
            philosopher = "جان جاك روسو",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٧١٢ – ١٧٧٨ م",
            reflection = "الوعي بما نكرره يومياً يصون حريتنا المستقبلية."
        ),
        PhilosophicalQuote(
            id = 90,
            text = "الألمُ الذي لا يكسرُ روحَك، يعمّقُ بصيرتَك ويهبكُ فهماً لا ينالُه المترفون.",
            englishText = "The suffering that fails to break your spirit deepens your insight and grants understanding unknown to comfort.",
            philosopher = "فريدريك نيتشه",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٨٤٤ – ١٩٠٠ م",
            reflection = "المعاناة الواعية تصقل الحس الإنساني وتكشف المعادن الحقيقية."
        ),
        PhilosophicalQuote(
            id = 91,
            text = "الموسيقى والرياضياتُ تهذّبانِ الروحَ وتعلّمانِ العقلَ تذوّقَ التناغمِ والنظام.",
            englishText = "Music and mathematics refine the soul and train the mind to discern harmony and order.",
            philosopher = "فيثاغورس",
            school = PhilosophicalSchool.GREEK,
            era = "٥٧٠ – ٤٩٥ ق.م",
            reflection = "الجمال والعلم يلتقيان في إدراك التناسق الخفي."
        ),
        PhilosophicalQuote(
            id = 92,
            text = "ما دمتَ حيّاً، فما زالَ بوسعِك أنْ تتعلّمَ كيفَ تحيا بحكمةٍ أعمقَ مما مضى.",
            englishText = "As long as you live, keep learning how to live with deeper wisdom than before.",
            philosopher = "لوسيوس سينيكا",
            school = PhilosophicalSchool.STOIC,
            era = "٤ ق.م – ٦٥ م",
            reflection = "التعلّم المستمر هو شباب العقل الدائم."
        ),
        PhilosophicalQuote(
            id = 93,
            text = "الحكيمُ يرى في كلِّ مخلوقٍ آيةً تدلُّ على نظامِ الكونِ وبديعِ صنعِه.",
            englishText = "The wise perceive in every creature a sign pointing to cosmic order and wondrous design.",
            philosopher = "ابن رشد",
            school = PhilosophicalSchool.ISLAMIC,
            era = "١١٢٦ – ١١٩٨ م",
            reflection = "التأمل في الموجودات يفتح باب الحكمة والإيمان العقلاني."
        ),
        PhilosophicalQuote(
            id = 94,
            text = "التعليمُ الحقُّ يهدفُ إلى تحريرِ العقلِ من الخوفِ والجمود، لا إلى حشوِه بالمسلّمات.",
            englishText = "True education aims to liberate the mind from fear and dogma, not pack it with unexamined slogans.",
            philosopher = "برتراند راسل",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٨٧٢ – ١٩٧٠ م",
            reflection = "الفضول النقدي يحوّل التعليم إلى متعة اكتشاف مستمرة."
        ),
        PhilosophicalQuote(
            id = 95,
            text = "الحوارُ الصادقُ بين إنسانَين يكشفُ لكَ ما لم تكنْ لتراهُ وأنتَ وحيدٌ في مرآتِك.",
            englishText = "Honest dialogue between two people reveals what you could never see alone in your own mirror.",
            philosopher = "مارتن بوبر",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٨٧٨ – ١٩٦٥ م",
            reflection = "اللقاء الإنساني الأصيل يثري الوعي ويبدّد العزلة."
        ),
        PhilosophicalQuote(
            id = 96,
            text = "إنّ الشجاعةَ هي أُولى الفضائل، لأنّها التي تضمنُ ممارسةَ سائرِ الفضائلِ بثبات.",
            englishText = "Courage is the foremost virtue, for it is what secures the steady practice of every other virtue.",
            philosopher = "أرسطو",
            school = PhilosophicalSchool.GREEK,
            era = "٣٨٤ – ٣٢٢ ق.م",
            reflection = "بدون الجرأة على الفعل الصحيح تبقى المبادئ حروفاً ساكنة."
        ),
        PhilosophicalQuote(
            id = 97,
            text = "لا تغضبْ من الناسِ حين يُخطئون؛ بل تذكّرْ أنّ الجهلَ هو الذي يقودُ خطاهم.",
            englishText = "Do not grow angry with people when they err; remember that ignorance guides their missteps.",
            philosopher = "ماركوس أوريليوس",
            school = PhilosophicalSchool.STOIC,
            era = "١٢١ – ١٨٠ م",
            reflection = "التفهّم والرحمة يطفئان نار الحقد في القلب."
        ),
        PhilosophicalQuote(
            id = 98,
            text = "مَن استغنى بعلمِه عن مشاورةِ العقلاء، أوشكَ أنْ يزلَّ في مواطنِ الاشتباه.",
            englishText = "Whoever relies solely on their own knowledge and spurns wise counsel risks stumbling in moments of doubt.",
            philosopher = "ابن مسكويه",
            school = PhilosophicalSchool.ISLAMIC,
            era = "٩٣٢ – ١٠٣٠ م",
            reflection = "تلاقح العقول يقي من أخطاء الانفراد بالرأي."
        ),
        PhilosophicalQuote(
            id = 99,
            text = "الإنسانُ يولدُ حرّاً، غيرَ أنّه يقيّدُ نفسَه بأوهامِ الترفِ والمظاهرِ الكاذبة.",
            englishText = "Human beings are born free, yet bind themselves in chains of false luxury and empty appearances.",
            philosopher = "جان جاك روسو",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٧١٢ – ١٧٧٨ م",
            reflection = "البساطة تحرر الإنسان من عبودية المظاهر."
        ),
        PhilosophicalQuote(
            id = 100,
            text = "الاختبارُ الحقيقيُّ للإنسانِ ليس في لحظاتِ السطوع، بل في قدرتِه على السيرِ حين ينطفئُ الضوء.",
            englishText = "The real test of a person is not in bright moments of triumph, but in walking on when the light goes out.",
            philosopher = "كارل ياسبرز",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٨٨٣ – ١٩٦٩ م",
            reflection = "المواقف الحدية تكشف جوهر الإرادة الإنسانية."
        )
    )
}
