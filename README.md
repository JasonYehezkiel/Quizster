# Quizster

[![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=flat&logo=kotlin&logoColor=white)](https://kotlinlang.org/)


Quizster is a simple application developed using Kotlin. It presents 10 random questions selected from a total pool of 30 yes-or-no questions. Each player has three hints they can use at any time during the game to reveal the correct answer. After the player completes all the questions, the application displays the final score and provides options to either play again or return to the main menu.

---

## 📑 Table of Contents
- [Features](#-features)  
- [Project Structure](#-project-structure)  
- [Setup](#-setup)  

---

## 🌟 Features
- ❓ Randomized yes/no questions  
- 💡 3 hints per user  
- 🏆 Final score display  
- 🔄 Replay or return to menu  

---

## 📂 Project Structure

```
app/src/main/
├── java/
│   └── com/example/quizster/
│       ├── ui/theme/
│       │   ├── Color.kt
│       │   ├── Theme.kt
│       │   └── Type.kt
│       ├── AboutActivity.kt
│       ├── MainActivity.kt
│       ├── Questions.kt
│       ├── QuizActivity.kt
│       ├── QuizBanks.kt
│       └── ScoreActivity.kt
├── res/
│   ├── drawable/       # icons, images, backgrounds
│   ├── layout/         # XML layout files
│   ├── font/           # custom fonts
│   └── values/         # colors, strings, themes
└── AndroidManifest.xml
```

---

## ⚡ Setup

### 1. Clone the repository
```bash
git clone https://github.com/yourusername/Quizster.git
cd Quizster
```

### 2. Open in Android Studio
1. Launch Android Studio
2. Click Open an existing project and select the cloned **Quizster** folder.
3. Wait for Gradle to sync and build the project.

### 3. Run on an Android Virtual Device
1. Open Device Manager in Android Studio
2. Create new virtual device (e.g., Medium Phone API 36.0)
3. Start the Emulator

---

## 👤 Author

Name: Jason Yehezkiel  
NIM: 191900531
University: Calvin Institute of Technology
