package com.example.data

import com.example.model.PhilosophicalQuote
import com.example.model.PhilosophicalSchool

internal object QuoteCatalogPart1 {
    val quotes: List<PhilosophicalQuote> = listOf(
        PhilosophicalQuote(
            id = 1,
            text = "اعرف نفسك، فبداية الحكمة الحقيقية أن يُدرك الإنسان حدود عقله ومساحة جهله.",
            englishText = "Know thyself, for true wisdom begins when a person recognizes the limits of reason and the expanse of ignorance.",
            philosopher = "سقراط",
            school = PhilosophicalSchool.GREEK,
            era = "٤٧٠ – ٣٩٩ ق.م",
            reflection = "المعرفة الذاتية هي حجر الأساس الذي يُبنى عليه كل بحث فلسفي صادق."
        ),
        PhilosophicalQuote(
            id = 2,
            text = "العقلُ السليمُ هو الذي يرى في الأزمات فرصةً لاختبار ثباته لا سبباً لانهياره.",
            englishText = "A sound mind sees in crises an opportunity to test its steadiness, not a cause for collapse.",
            philosopher = "ماركوس أوريليوس",
            school = PhilosophicalSchool.STOIC,
            era = "١٢١ – ١٨٠ م",
            reflection = "السيطرة على الانفعال الداخلي تحوّل العقبات إلى معلم صامت للقوة."
        ),
        PhilosophicalQuote(
            id = 3,
            text = "السعادةُ الحقيقيةُ ليست في كثرةِ المقتنيات، بل في صفاءِ النفسِ واكتمالِ الفضيلة.",
            englishText = "True happiness lies not in abundant possessions, but in serenity of soul and the fulfillment of virtue.",
            philosopher = "أرسطو",
            school = PhilosophicalSchool.GREEK,
            era = "٣٨٤ – ٣٢٢ ق.م",
            reflection = "الازدهار الإنساني يتحقق بممارسة الحكمة والاعتدال لا باللذة العابرة."
        ),
        PhilosophicalQuote(
            id = 4,
            text = "من عرفَ اللهَ هانتْ عليه مصائبُ الدنيا، ومن عرفَ نفسَه لم يغترَّ بمدحِ الناس.",
            englishText = "Whoever truly knows the Divine bears worldly trials lightly, and whoever knows themselves is never deceived by praise.",
            philosopher = "أبو حامد الغزالي",
            school = PhilosophicalSchool.ISLAMIC,
            era = "١٠٥٨ – ١١١١ م",
            reflection = "الطمأنينة الروحية تبدأ حين يتحرر الإنسان من التعلّق الزائد بأحكام الآخرين."
        ),
        PhilosophicalQuote(
            id = 5,
            text = "الحريةُ ليست غيابَ القيود، بل قدرتُك على أن تختارَ موقفَك تجاه ما لا تستطيع تغييره.",
            englishText = "Freedom is not the absence of limits, but your power to choose your stance toward what you cannot change.",
            philosopher = "إبكتيتوس",
            school = PhilosophicalSchool.STOIC,
            era = "٥٠ – ١٣٥ م",
            reflection = "التمييز بين ما نملكه وما لا نملكه هو أقصر طريق إلى السكينة."
        ),
        PhilosophicalQuote(
            id = 6,
            text = "الشكُّ أولُ مراتبِ اليقين؛ فمن لم يشكَّ لم ينظر، ومن لم ينظر لم يُبصر.",
            englishText = "Doubt is the first threshold of certainty; whoever never doubts never examines, and whoever never examines never truly sees.",
            philosopher = "رينيه ديكارت",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٥٩٦ – ١٦٥٠ م",
            reflection = "الشك المنهجي ليس هدماً للمعرفة، بل غربلةٌ تصل بالعقل إلى أساسٍ متين."
        ),
        PhilosophicalQuote(
            id = 7,
            text = "إنّ المدينةَ الفاضلةَ لا تقومُ إلّا بتعاونِ العقولِ الحرّةِ على طلبِ الخيرِ المشترك.",
            englishText = "The virtuous city rises only through the cooperation of free minds in pursuit of the common good.",
            philosopher = "أبو نصر الفارابي",
            school = PhilosophicalSchool.ISLAMIC,
            era = "٨٧٢ – ٩٥٠ م",
            reflection = "الأخلاق الفردية تبلغ كمالها عندما تتحوّل إلى تعاون مدني يرفع شأن المجتمع."
        ),
        PhilosophicalQuote(
            id = 8,
            text = "المرءُ يتألّمُ في مخيّلتِه أكثرَ ممّا يتألّمُ في الواقع؛ فلنُحكِم لجامَ الظنون.",
            englishText = "We suffer far more in imagination than in reality; therefore, let us rein in our anxious assumptions.",
            philosopher = "لوسيوس سينيكا",
            school = PhilosophicalSchool.STOIC,
            era = "٤ ق.م – ٦٥ م",
            reflection = "كثير من مخاوفنا استباقٌ لأحداث قد لا تقع أبداً."
        ),
        PhilosophicalQuote(
            id = 9,
            text = "الدهشةُ هي أمُّ الفلسفة؛ فالعينُ التي تألفُ العجائبَ تفقدُ شغفَ السؤال.",
            englishText = "Wonder is the mother of philosophy; an eye grown numb to marvels loses its passion to question.",
            philosopher = "أفلاطون",
            school = PhilosophicalSchool.GREEK,
            era = "٤٢٧ – ٣٤٧ ق.م",
            reflection = "القدرة على التساؤل أمام الأشياء المعتادة هي علامة العقل الحي."
        ),
        PhilosophicalQuote(
            id = 10,
            text = "مَنْ يمتلكُ سبباً يعيشُ من أجلِه، يستطيعُ أن يتحمّلَ كلَّ كيفٍ تعترضُ طريقَه.",
            englishText = "Whoever has a 'why' to live for can bear almost any 'how' that stands in the way.",
            philosopher = "فريدريك نيتشه",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٨٤٤ – ١٩٠٠ م",
            reflection = "المعنى الداخلي يمنح الإنسان صلابةً تتجاوز قسوة الظروف."
        ),
        PhilosophicalQuote(
            id = 11,
            text = "الحقُّ لا يضادُّ الحقَّ، بل يوافقُه ويشهدُ له إذا التمسنا البرهانَ بصدق.",
            englishText = "Truth does not contradict truth; rather, it agrees with it and bears witness to it when sought with honest proof.",
            philosopher = "ابن رشد",
            school = PhilosophicalSchool.ISLAMIC,
            era = "١١٢٦ – ١١٩٨ م",
            reflection = "العقل والنقل الأصيل يتكاملان في البحث عن الحقيقة دون تعارض."
        ),
        PhilosophicalQuote(
            id = 12,
            text = "تجرّأ على استخدامِ عقلِك، فذاك هو شعارُ التنويرِ الأسمى والتحرّرِ من الوصاية.",
            englishText = "Dare to use your own reason—that is the supreme motto of Enlightenment and emancipation from tutelage.",
            philosopher = "إيمانويل كانط",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٧٢٤ – ١٨٠٤ م",
            reflection = "النضج الفكري يبدأ عندما يتحمل الفرد مسؤولية التفكير بنفسه."
        ),
        PhilosophicalQuote(
            id = 13,
            text = "الحياةُ غيرُ المفحوصةِ لا تستحقُّ أن تُعاش؛ تأمّلْ مسارَك قبلَ أن تُسرِعَ الخُطى.",
            englishText = "The unexamined life is not worth living; reflect upon your path before hurrying your steps.",
            philosopher = "سقراط",
            school = PhilosophicalSchool.GREEK,
            era = "٤٧٠ – ٣٩٩ ق.م",
            reflection = "مراجعة القيم والأفعال تحوّل الأيام المتكررة إلى تجربة واعية."
        ),
        PhilosophicalQuote(
            id = 14,
            text = "المغبونُ مَنْ ضاعتْ أيامُه في انتظارِ غدٍ لا يأتي، ونسيَ أنَّ اللحظةَ هي كلُّ ما يملك.",
            englishText = "Deceived is the one whose days slip away awaiting a tomorrow that never arrives, forgetting the present moment is all we own.",
            philosopher = "ماركوس أوريليوس",
            school = PhilosophicalSchool.STOIC,
            era = "١٢١ – ١٨٠ م",
            reflection = "الحضور الذهني في الآن يحرر الإنسان من قلق المستقبل وحسرة الماضي."
        ),
        PhilosophicalQuote(
            id = 15,
            text = "النفسُ الإنسانيةُ جوهرٌ لطيفٌ يزدادُ إشراقاً كلّما تجرّدَ من أدرانِ الجهلِ والغضب.",
            englishText = "The human soul is a subtle essence that grows ever brighter as it sheds the stains of ignorance and anger.",
            philosopher = "ابن سينا",
            school = PhilosophicalSchool.ISLAMIC,
            era = "٩٨٠ – ١٠٣٧ م",
            reflection = "تزكية النفس وتنمية المعرفة مساران متلازمان للارتقاء الروحي والعقلي."
        ),
        PhilosophicalQuote(
            id = 16,
            text = "الإنسانُ مشروعُ نفسِه؛ يبدأُ بالوجودِ ثم يصنعُ ماهيتَه باختياراتِه المتواصلة.",
            englishText = "Humanity is its own project: existence comes first, and we forge our essence through continual choices.",
            philosopher = "جان بول سارتر",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٩٠٥ – ١٩٨٠ م",
            reflection = "أفعالنا اليومية هي التي ترسم هويتنا الحقيقية لا الأقوال المجردة."
        ),
        PhilosophicalQuote(
            id = 17,
            text = "ليس هناك طريقٌ إلى السلام، بل السلامُ نفسُه هو الطريقُ الذي ينبغي أن نسلكَه.",
            englishText = "There is no separate road to peace; peace itself is the road we must walk.",
            philosopher = "باروخ سبينوزا",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٦٣٢ – ١٦٧٧ م",
            reflection = "التسامح والفهم العميق للطبيعة البشرية يطفئان جذور الصراع."
        ),
        PhilosophicalQuote(
            id = 18,
            text = "لا تُقاسُ قيمةُ الإنسانِ بما يُنالُ من التصفيق، بل بما يصنعُه حين لا يراهُ أحد.",
            englishText = "A person's worth is measured not by public applause, but by what they do when no one is watching.",
            philosopher = "أفلاطون",
            school = PhilosophicalSchool.GREEK,
            era = "٤٢٧ – ٣٤٧ ق.م",
            reflection = "النزاهة الداخلية هي المقياس الأصدق للشخصية الأخلاقية."
        ),
        PhilosophicalQuote(
            id = 19,
            text = "الظلمُ مؤذِنٌ بخرابِ العمران، والعدلُ هو الأساسُ الذي تستقيمُ به الدولُ والنفوس.",
            englishText = "Injustice heralds the ruin of civilization, while justice is the pillar by which states and souls stand upright.",
            philosopher = "ابن خلدون",
            school = PhilosophicalSchool.ISLAMIC,
            era = "١٣٣٢ – ١٤٠٦ م",
            reflection = "التاريخ يعلمنا أن استقرار المجتمعات مرهون بإقامة العدل وصون الكرامة."
        ),
        PhilosophicalQuote(
            id = 20,
            text = "في قلبِ الشتاءِ القارس، أدركتُ أخيراً أنَّ في داخلي صيفاً لا يُقهر.",
            englishText = "In the midst of bitter winter, I finally discovered within me an invincible summer.",
            philosopher = "ألبير كامو",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٩١٣ – ١٩٦٠ م",
            reflection = "الصمود الإنساني أمام عبثية العالم ينبع من نور داخلي لا تطفئه الصعاب."
        ),
        PhilosophicalQuote(
            id = 21,
            text = "الصديقُ الحقيقيُّ روحٌ واحدةٌ تسكنُ في جسدَين، يشدُّ أزرَك بالحقِّ لا بالمجاملة.",
            englishText = "A true friend is a single soul dwelling in two bodies, strengthening you with truth rather than flattery.",
            philosopher = "أرسطو",
            school = PhilosophicalSchool.GREEK,
            era = "٣٨٤ – ٣٢٢ ق.م",
            reflection = "الصداقة القائمة على الفضيلة أسمى وأبقى من صداقات المصلحة."
        ),
        PhilosophicalQuote(
            id = 22,
            text = "الوقتُ أنفسُ ما تملك؛ فلا تُنفقْ عمرَك في إثباتِ صوابِك لمن لا يريدُ أن يفهم.",
            englishText = "Time is your most precious possession; do not spend your life proving yourself right to those unwilling to understand.",
            philosopher = "لوسيوس سينيكا",
            school = PhilosophicalSchool.STOIC,
            era = "٤ ق.م – ٦٥ م",
            reflection = "حفظ الطاقة الذهنية عن الجدال العقيم من علامات الرشد الرواقي."
        ),
        PhilosophicalQuote(
            id = 23,
            text = "كلُّ ما يُعرفُ بالقلبِ الصافي من المعاني، تعجزُ الألفاظُ الضيّقةُ عن حصرِ بهائه.",
            englishText = "Every meaning known by a pure heart outgrows narrow words that try to confine its radiance.",
            philosopher = "محيي الدين ابن عربي",
            school = PhilosophicalSchool.ISLAMIC,
            era = "١١٦٥ – ١٢٤٠ م",
            reflection = "التجربة الروحية العميقة تتسع في الوجدان أكثر مما تتسع له اللغة."
        ),
        PhilosophicalQuote(
            id = 24,
            text = "لا تُعامِلْ أحداً بوصفِه مجرّدَ وسيلةٍ لغايتِك، بل بوصفِه غايةً في ذاتِه.",
            englishText = "Treat every human being never merely as a means to your ends, but always as an end in themselves.",
            philosopher = "إيمانويل كانط",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٧٢٤ – ١٨٠٤ م",
            reflection = "القاعدة الذهبية للأخلاق الكانطية تصون كرامة الإنسان في كل ظرف."
        ),
        PhilosophicalQuote(
            id = 25,
            text = "لا ينبغي أن تُقلقَنا الأشياءُ نفسُها، بل أحكامُنا وتصوّراتُنا التي نُضفيها عليها.",
            englishText = "People are disturbed not by things themselves, but by the judgments and meanings they attach to them.",
            philosopher = "إبكتيتوس",
            school = PhilosophicalSchool.STOIC,
            era = "٥٠ – ١٣٥ م",
            reflection = "تغيير زاوية التفسير يبدّل الأثر النفسي للحدث ذاته."
        ),
        PhilosophicalQuote(
            id = 26,
            text = "الخطرُ الحقيقيُّ ليس في أنْ تُخطئَ وأنتَ تسعى، بل في أنْ تتوقّفَ عن التساؤلِ خوفاً من الخطأ.",
            englishText = "The real danger is not erring while you strive, but ceasing to question out of fear of being wrong.",
            philosopher = "برتراند راسل",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٨٧٢ – ١٩٧٠ م",
            reflection = "التواضع العلمي والفضول العقلي يحميان الإنسان من الجمود الفكري."
        ),
        PhilosophicalQuote(
            id = 27,
            text = "مَنْ قاتلَ الوحوشَ طويلاً، فليحذرْ أنْ يتحوّلَ هو نفسُه إلى وحشٍ في غمارِ الصراع.",
            englishText = "Whoever fights monsters too long must take care lest they become a monster themselves.",
            philosopher = "فريدريك نيتشه",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٨٤٤ – ١٩٠٠ م",
            reflection = "المحافظة على المبادئ أثناء المواجهة أصعب وأهم من الانتصار نفسه."
        ),
        PhilosophicalQuote(
            id = 28,
            text = "الفضيلةُ وسطٌ محمودٌ بين رذيلتَين؛ فالشجاعةُ بين التهوّرِ والجبن، والكرمُ بين الإسرافِ والبخل.",
            englishText = "Virtue is a praiseworthy mean between two extremes: courage between recklessness and cowardice, generosity between waste and greed.",
            philosopher = "أرسطو",
            school = PhilosophicalSchool.GREEK,
            era = "٣٨٤ – ٣٢٢ ق.م",
            reflection = "الاعتدال الذهبي يحقق التوازن بين اندفاع الغريزة وتصلّب الخوف."
        ),
        PhilosophicalQuote(
            id = 29,
            text = "إذا اتّسعتْ معرفتُك، ضاقتْ دائرةُ تعصّبِك، وأبصرتَ في اختلافِ الناسِ حكمةً لا عداوة.",
            englishText = "As your knowledge widens, your circle of prejudice narrows, and you see wisdom rather than enmity in human diversity.",
            philosopher = "أبو بكر الرازي",
            school = PhilosophicalSchool.ISLAMIC,
            era = "٨٦٥ – ٩٢٥ م",
            reflection = "سعة الأفق العلمي تزرع الرحمة وتقلل من حدة الأحكام القاطعة."
        ),
        PhilosophicalQuote(
            id = 30,
            text = "ثروةُ الإنسانِ الحقيقيةُ ليست في كثرةِ ما يملك، بل في قِلّةِ ما يحتاجُ إليه.",
            englishText = "True human wealth consists not in how much one owns, but in how little one needs.",
            philosopher = "زينون الرواقي",
            school = PhilosophicalSchool.STOIC,
            era = "٣٣٤ – ٢٦٢ ق.م",
            reflection = "الاكتفاء الداخلي يمنح استقلالية لا تهددها تقلبات السوق والزمن."
        ),
        PhilosophicalQuote(
            id = 31,
            text = "الحقيقةُ كالنورِ الهادئ؛ لا تحتاجُ إلى صراخِ الجدلِ لتثبتَ حضورَها في العقول.",
            englishText = "Truth is like a quiet light; it needs no shouting debate to prove its presence to the mind.",
            philosopher = "جون لوك",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٦٣٢ – ١٧٠٤ م",
            reflection = "الوضوح الهادئ والحجة الرزينة أبقى أثراً من الصخب البلاغي."
        ),
        PhilosophicalQuote(
            id = 32,
            text = "الحياةُ لا تُفهمُ إلّا بالنظرِ إلى الوراء، ولكنّها لا بدَّ أن تُعاشَ بالنظرِ إلى الأمام.",
            englishText = "Life can only be understood looking backwards, yet it must be lived looking forwards.",
            philosopher = "سورين كيركغور",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٨١٣ – ١٨٥٥ م",
            reflection = "التجربة تُفهم بعد انقضائها، أما القرار الشجاع فيُتخذ في قلب المجهول."
        ),
        PhilosophicalQuote(
            id = 33,
            text = "التعلّمُ الحقيقيُّ ليس حشواً للذاكرة، بل إيقادٌ لشعلةِ الفهمِ في الروح.",
            englishText = "True education is not cramming the memory, but kindling the flame of understanding in the soul.",
            philosopher = "سقراط",
            school = PhilosophicalSchool.GREEK,
            era = "٤٧٠ – ٣٩٩ ق.م",
            reflection = "التعليم التوليدي يستخرج الحكمة الكامنة في عقل المتعلّم عبر الحوار."
        ),
        PhilosophicalQuote(
            id = 34,
            text = "تكلّموا بقدرِ ما يقتضيهِ الصدق، واصمتوا عندما يصبحُ الصمتُ أبلغَ من الكلمات.",
            englishText = "Speak only as much as truth requires, and keep silent when silence speaks deeper than words.",
            philosopher = "فيثاغورس",
            school = PhilosophicalSchool.GREEK,
            era = "٥٧٠ – ٤٩٥ ق.م",
            reflection = "الصمت التأملي يسبق الكلمة الرصينة ويعطيها وزنها."
        ),
        PhilosophicalQuote(
            id = 35,
            text = "أعقلُ الناسِ مَن لم يتكلّفْ ما لا يعنيه، ووجّهَ همّتَه إلى إصلاحِ سريرتِه وعملِه.",
            englishText = "Wisest is the one who meddles not in what does not concern them, and devotes effort to refining heart and deed.",
            philosopher = "ابن مسكويه",
            school = PhilosophicalSchool.ISLAMIC,
            era = "٩٣٢ – ١٠٣٠ م",
            reflection = "تهذيب الأخلاق يبدأ بترك الفضول المشتّت والانشغال ببناء الذات."
        ),
        PhilosophicalQuote(
            id = 36,
            text = "تقبّلْ ما يقعُ لك بقلبٍ مطمئنّ، كما لو أنّك اخترتَ أنتَ أن يكونَ على هذا النحو.",
            englishText = "Accept whatever befalls you with a serene heart, as though you had chosen it to unfold that very way.",
            philosopher = "ماركوس أوريليوس",
            school = PhilosophicalSchool.STOIC,
            era = "١٢١ – ١٨٠ م",
            reflection = "حب القدر يحوّل المقاومة المستنزفة إلى قوة متصالحة."
        ),
        PhilosophicalQuote(
            id = 37,
            text = "الموهبةُ تُنمّيها القراءة، أمّا الشخصيةُ الصلبةُ فتُصقلُها العزلةُ الهادئةُ والتجربة.",
            englishText = "Talent grows through reading, while resilient character is forged in quiet solitude and lived experience.",
            philosopher = "أرتور شوبنهاور",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٧٨٨ – ١٨٦٠ م",
            reflection = "لحظات الخلوة الصادقة تكشف للإنسان جوهر أفكاره بعيداً عن الضجيج."
        ),
        PhilosophicalQuote(
            id = 38,
            text = "العقلُ كالمظلّة؛ لا يؤدي وظيفتَه على الوجهِ الأكملِ إلّا حين يكونُ منفتحاً.",
            englishText = "The mind is like a parachute: it fulfills its purpose best only when it is open.",
            philosopher = "فرانسيس بيكون",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٥٦١ – ١٦٢٦ م",
            reflection = "الانفتاح النقدي يحفظ العقل من أوهام التحيّز المسبق."
        ),
        PhilosophicalQuote(
            id = 39,
            text = "الجاهلُ يؤكّد، والعالِمُ يشكُّ ويبحث، والعاقلُ يتروّى قبلَ أن يُصدرَ حكمَه.",
            englishText = "The ignorant assert blindly, the scholar doubts and investigates, and the wise pause before passing judgment.",
            philosopher = "أرسطو",
            school = PhilosophicalSchool.GREEK,
            era = "٣٨٤ – ٣٢٢ ق.م",
            reflection = "التأنّي في الحكم سمة المعرفة العميقة التي تدرك تعقيد الواقع."
        ),
        PhilosophicalQuote(
            id = 40,
            text = "إذا أردتَ أن تعرفَ قدرَ إنسان، فانظرْ إلى الأشياءِ الصغيرةِ التي تستفزُّ غضبَه.",
            englishText = "If you wish to gauge someone's stature, observe the size of the small things that provoke their anger.",
            philosopher = "أبو حيان التوحيدي",
            school = PhilosophicalSchool.ISLAMIC,
            era = "٩٢٣ – ١٠٢٣ م",
            reflection = "ضبط النفس أمام المنغصات اليومية يكشف عن معدن الحكمة الحقيقي."
        ),
        PhilosophicalQuote(
            id = 41,
            text = "لا تؤجّلْ ممارسةَ الفضيلةِ إلى الغد؛ فكلُّ ساعةٍ تمضي هي جزءٌ من حياتِك لن يعود.",
            englishText = "Do not postpone practicing virtue until tomorrow; every passing hour is a part of your life that never returns.",
            philosopher = "لوسيوس سينيكا",
            school = PhilosophicalSchool.STOIC,
            era = "٤ ق.م – ٦٥ م",
            reflection = "العمل الصالح والفعل الواعي لا يحتملان التسويف."
        ),
        PhilosophicalQuote(
            id = 42,
            text = "في كلِّ عددٍ نظامٌ خفيّ، وفي كلِّ نظامٍ موسيقى صامتةٌ تُرتّبُ الفوضى في الكون.",
            englishText = "Within every number hides an order, and within every order plays a silent music arranging chaos into cosmos.",
            philosopher = "فيثاغورس",
            school = PhilosophicalSchool.GREEK,
            era = "٥٧٠ – ٤٩٥ ق.م",
            reflection = "الأرقام والنسب الهندسية لغةٌ كونية تكشف انسجام الوجود."
        ),
        PhilosophicalQuote(
            id = 43,
            text = "قراءةُ الكتبِ الجيّدةِ حوارٌ مفتوحٌ مع أصفى العقولِ التي عاشتْ عبرَ العصور.",
            englishText = "Reading fine books is an open conversation with the clearest minds who ever lived across the ages.",
            philosopher = "رينيه ديكارت",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٥٩٦ – ١٦٥٠ م",
            reflection = "المطالعة الفلسفية تمدّ عمرنا العقلي وتصلنا بتجارب الحكماء."
        ),
        PhilosophicalQuote(
            id = 44,
            text = "إنّ الشجاعةَ ليست انعدامَ الخوف، بل الاعترافُ بوجودِه مع الإصرارِ على التقدّم.",
            englishText = "Courage is not the absence of fear, but acknowledging its presence while insisting on moving forward.",
            philosopher = "ألبير كامو",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٩١٣ – ١٩٦٠ م",
            reflection = "الجرأة الحقيقية تُولد في لحظة التردد حين يختار الإنسان الاستمرار."
        ),
        PhilosophicalQuote(
            id = 45,
            text = "العدالةُ في النفسِ هي أن يعرفَ كلُّ قوى الروحِ مكانَها تحت قيادةِ الحكمة.",
            englishText = "Justice within the soul is when every faculty knows its rightful place under the guidance of wisdom.",
            philosopher = "أفلاطون",
            school = PhilosophicalSchool.GREEK,
            era = "٤٢٧ – ٣٤٧ ق.م",
            reflection = "انسجام العقل والشجاعة والرغبة يصنع سلاماً داخلياً راسخاً."
        ),
        PhilosophicalQuote(
            id = 46,
            text = "مَنْ طلبَ الحكمةَ ليتفاخرَ بها خَسِرَ نورَها، ومَنْ طلبَها ليعملَ بها أضاءتْ دروبَه.",
            englishText = "Whoever seeks wisdom to boast loses its light; whoever seeks it to practice it illuminates every path.",
            philosopher = "الكندي",
            school = PhilosophicalSchool.ISLAMIC,
            era = "٨٠١ – ٨٧٣ م",
            reflection = "غاية الفلسفة الأولى هي إدراك الحق والعمل به."
        ),
        PhilosophicalQuote(
            id = 47,
            text = "المعرفةُ قوّةٌ إذا اقترنتْ بالتواضع، وعبءٌ ثقيلٌ إذا قادَتْ صاحبَها إلى الغرور.",
            englishText = "Knowledge is power when paired with humility, and a heavy burden when it leads its bearer to arrogance.",
            philosopher = "فرانسيس بيكون",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٥٦١ – ١٦٢٦ م",
            reflection = "العلم الحقيقي يُشعر صاحبه بضآلة ما يعرف مقارنة بما يجهل."
        ),
        PhilosophicalQuote(
            id = 48,
            text = "تحكّمْ في صباحِك وتدبّرْ خطواتِك، فالبداياتُ المنضبطةُ تُثمرُ أياماً متزنة.",
            englishText = "Command your morning and weigh your steps, for disciplined beginnings yield balanced days.",
            philosopher = "إبكتيتوس",
            school = PhilosophicalSchool.STOIC,
            era = "٥٠ – ١٣٥ م",
            reflection = "الروتين الذهني الصباحي يهيئ العقل لمواجهة تقلبات النهار."
        ),
        PhilosophicalQuote(
            id = 49,
            text = "الفرحُ انتقالٌ بالوعيِ من كمالٍ أقلَّ إلى كمالٍ أعظم، وليس مجرّدَ انفعالٍ عابر.",
            englishText = "Joy is the mind's passage from a lesser perfection to a greater one, not merely a fleeting emotion.",
            philosopher = "باروخ سبينوزا",
            school = PhilosophicalSchool.ENLIGHTENMENT,
            era = "١٦٣٢ – ١٦٧٧ م",
            reflection = "كل خطوة نحو الفهم والنمو تزيد طاقة الإنسان الحيوية."
        ),
        PhilosophicalQuote(
            id = 50,
            text = "أنْ تكونَ نفسَك في عالمٍ يحاولُ باستمرارٍ أن يجعلَك نسخةً من غيرك، هو أعظمُ إنجاز.",
            englishText = "To remain yourself in a world constantly striving to make you an imitation of others is the greatest achievement.",
            philosopher = "رالف والدو إيمرسون",
            school = PhilosophicalSchool.EXISTENTIAL,
            era = "١٨٠٣ – ١٨٨٢ م",
            reflection = "الأصالة الفكرية تتطلب شجاعة الاستقلال عن القطيع."
        )
    )
}
