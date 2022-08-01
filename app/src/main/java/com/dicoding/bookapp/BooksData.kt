package com.dicoding.bookapp

object BooksData {
    private val booksTitle =
        arrayOf("Atomic Habits", "Breath", "Shoe Dog", "Keajaiban Toko Kelontong Namiya", "The Psychology of Money")
    private val booksSubtitle = arrayOf(
        "Atomic Habits \"Cara Mudah dan Terbukti Untuk Membentuk kebiasaan Baik dan Menghilangkan Kebiasaan Buruk\"",
        "Breath: Cara Bernapas Dengan Benar",
        "Shoe Dog",
        "Keajaiban Toko Kelontong Namiya (The Miracles of the Namiya General Store/Namiya Zakkaten No Kiseki)",
        "The Psychology of Money. Timeless lessons on wealth, greed, and happiness"
    )
    private val booksAuthor =
        arrayOf("James Clear", "James Nestor", "Phil Knight", "Keigo Higashino", "Morgan Housel")
    private val booksGenre = arrayOf(
        BookGenres.SELF_IMPROVEMENT.value,
        BookGenres.LIFE_STYLE.value,
        BookGenres.BIOGRAPHY.value,
        BookGenres.MYSTERY.value,
        BookGenres.FINANCE.value
    )
    private val booksPages = intArrayOf(352, 332, 386, 400, 256)
    private val booksPublisher = arrayOf(
        "Gramedia Pustaka Utama",
        "Gramedia Pustaka Utama",
        "Simon & Schuster, Inc.",
        "Gramedia Pustaka Utama",
        "Harriman House"
    )
    private val booksISBN =
        arrayOf("9786020633176", "9780735213616", "9781471146725", "9786020648293", "9780857197689")
    private val booksPublishDate =
        arrayOf("15 September 2019", "22 Juli 2021", "26 April 2016", "16 Desember 2020", "8 September 2020")
    private val booksDescription = arrayOf(
        "Orang mengira ketika Anda ingin mengubah hidup, Anda perlu memikirkan hal-hal besar. Namun pakar kebiasaan terkenal kelas dunia James Clear telah menemukan sebuah cara lain. Ia tahu bahwa perubahan nyata berasal dari efek gabungan ratusan keputusan kecil—dari mengerjakan dua push-up sehari, bangun lima menit lebih awal, sampai menahan sebentar hasrat untuk menelepon.\n" +
                "Ia menyebut semua tadi atomic habits.",
        "Tak ada yang lebih penting bagi kesehatan dan kesejahteraan kita selain bernapas: hirup udara, keluarkan, ulangi 25.000 kali sehari. Namun, sebagai suatu spesies, manusia telah kehilangan kemampuan untuk bernapas dengan benar, dengan konsekuensi yang serius. Dalam BREATH, James Nestor berkeliling dunia untuk menemukan ilmu pengetahuan yang tersembunyi di balik praktik pernapasan kuno untuk mencari tahu apa yang salah dan bagaimana memperbaikinya.\n" +
                "Penelitian modern menunjukkan bahwa membuat sedikit perubahan pada cara kita bernapas dapat: meningkatkan kinerja dalam berolahraga; meremajakan organ dalam; menghentikan dengkuran, alergi, asma, dan penyakit autoimun; bahkan bisa meluruskan tulang belakang yang mengalami skoliosis.\n" +
                "Kelihatannya tak mungkin, tapi ternyata mungkin. Menggali ribuan tahun kebijaksanaan kuno dan studi mutakhir dalam pulmonologi, psikologi, biokimia, dan fisiologi manusia, BREATH mengubah kebijaksanaan konvensional dari apa yang kita pikir kita ketahui tentang fungsi biologis paling dasar ini.\n" +
                "Setelah membaca buku ini, kita tak akan bernapas dengan cara yang sama lagi.",
        "Shoe Dog is a memoir by Nike co-founder Phil Knight. The memoir chronicles the history of Nike from its founding as Blue Ribbon Sports and its early challenges to its evolution into one of the world's most recognized and profitable companies. It also highlights certain parts of Phil Knight's life." +
                " Bill Gates named Shoe Dog one of his five favorite books of 2016 and called it \"An amazing tale, a refreshingly honest reminder of what the path to business success really looks like. It’s a messy, perilous, and chaotic journey, riddled with mistakes, endless struggles, and sacrifice. Phil Knight opens up in ways few CEOs are willing to do.\"",
        "Ketika tiga pemuda berandal bersembunyi di toko kelontong tak berpenghuni setelah melakukan pencurian, sepucuk surat misterius mendadak diselipkan ke dalam toko melalui lubang surat. Surat yang berisi permintaan saran. Sungguh aneh. " +
                "Namun, surat aneh itu ternyata membawa mereka dalam petualangan melintasi waktu, menggantikan peran kakek pemilik toko kelontong yang menghabiskan tahun-tahun terakhirnya memberikan nasihat tulus kepada orang-orang yang meminta bantuan. Hanya untuk satu malam. Dan saat fajar menjelang, hidup ketiga sahabat itu tidak akan pernah sama lagi...",
        "Doing well with money isn't necessarily about what you know. It's about how you behave. And behavior is hard to teach, even to really smart people. Money--investing, personal finance, and business decisions--is typically taught as a math-based field, where data and formulas tell us exactly what to do. But in the real world people don't make financial decisions on a spreadsheet." +
                " They make them at the dinner table, or in a meeting room, where personal history, your own unique view of the world, ego, pride, marketing, and odd incentives are scrambled together. In The Psychology of Money, award-winning author Morgan Housel shares 19 short stories exploring the strange ways people think about money and teaches you how to make better sense of one of life's most important topics."
    )
    private val booksLanguage =
        arrayOf(BookLanguages.ID.value, BookLanguages.ID.value, BookLanguages.EN.value, BookLanguages.ID.value, BookLanguages.EN.value)
    private val booksImage = intArrayOf(
        R.drawable.img_atomic_habits_cover,
        R.drawable.img_breath_cover,
        R.drawable.img_shoe_dog_cover,
        R.drawable.img_keajaiban_toko_kelontong_namiya_cover,
        R.drawable.img_the_psychology_of_money_cover
    )

    val listData: ArrayList<Book>
        get() {
            val list = arrayListOf<Book>()
            for (position in booksTitle.indices) {
                val book = Book()

                book.title = booksTitle[position]
                book.subtitle = booksSubtitle[position]
                book.author = booksAuthor[position]
                book.genre = booksGenre[position]
                book.pages = booksPages[position]
                book.publisher = booksPublisher[position]
                book.isbn = booksISBN[position]
                book.publishDate = booksPublishDate[position]
                book.description = booksDescription[position]
                book.language = booksLanguage[position]
                book.cover = booksImage[position]
                list.add(book)
            }
            return list
        }
}