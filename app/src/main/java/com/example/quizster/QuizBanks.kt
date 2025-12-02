package com.example.quizster

object QuizBanks {
    private val allQuestions = listOf(
        Questions("Bumi berbentuk bulat.", true),
        Questions("Matahari mengelilingi bumi.", false),
        Questions("Air beku di atas 0°C akan mencair.", true),
        Questions("Java adalah bahasa pemograman.", true),
        Questions("Manusia dapat benapas di ruang hampa tanpa alat.", false),
        Questions("Gunung Everest adalah gunung tertinggi di dunia.", true),
        Questions("Burung unta dapat terbang seperti burung lainnya.", false),
        Questions("Koala berasal dari Afrika.", false),
        Questions("Indonesia memiliki lebih dari 17.000 pulau.", true),
        Questions("Planet terdekat dari matahari adalah Venus.", false),
        Questions("Cumi-cumi memiliki tiga hati.", true),
        Questions("Rusia adalah negara terkecil di dunia.", false),
        Questions("Laut mati tidak memiliki kehidupan.", false),
        Questions("Hewan mamalia bertelur.", false),
        Questions("Air mendidih di 100°C pada tekanan standar.", true),
        Questions("Bulan lebih besar dari Matahari.", false),
        Questions("Tomat adalah buah.", true),
        Questions("Gajah adalah hewan terkecil di dunia.", false),
        Questions("Oksigen diperlukan untuk respirasi manusia.", true),
        Questions("Kuda laut jantan mengandung dan melahirkan anak.", true),
        Questions("Jerapah memiliki leher terpendek di dunia.", false),
        Questions("Kopi berasal dari Brasil.", true),
        Questions("Planet terbesar di tata surya adalah Jupiter.", true),
        Questions("Air laut lebih asin daripada air tawar.", true),
        Questions("Kucing selalu hidup di lingkungan kering.", false),
        Questions("Gunung Fuji terletak di Jepang.", true),
        Questions("Bambu adalah jenis pohon.", false),
        Questions("Burung penguin bisa terbang.", false),
        Questions("Kelinci adalah hewan herbivora.", true),
        Questions("Semut bisa mengangkat benda 50 kali berat tubuhnya.", true)
        )

    fun getRandomQuestions(count: Int = 10): List<Questions> {
        return allQuestions.shuffled().take(count)
    }
}