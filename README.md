# Assignment 1 - Onboarding Screens
**Course:** Mobile App Development 2  

---

## 📱 About the App
A multi-step user onboarding experience built using Android Fragments.
The app collects user information across multiple screens and demonstrates
Fragment-to-Activity communication using Interfaces.

---

## 🗺️ App Flow
Fragment1 (Welcome Screen) → Fragment2 (User Info) → Fragment3 (Confirmation)

---

## ✅ Features Implemented

### Fragment1
- Welcome screen with an image and text

### Fragment2
- Collects user information:
  - Name
  - Email
  - Gender (Male/Female)
  - University
- Communicates with MainActivity using **Fragment2Listener** interface

### Fragment3
- Displays the user's name received from MainActivity via **Bundle**
- Confirmation CheckBox: *"I confirm I have read and agree to use the app."*
- Button is **disabled** by default
- When CheckBox is checked:
  - Button becomes **enabled**
  - Button text changes from **"Continue"** to **"Finish"**
- When CheckBox is unchecked:
  - Button becomes **disabled** again
- Communicates with MainActivity using **Fragment3Listener** interface

---

## 🏗️ Architecture
- **Fragment-to-Activity Communication:** Using Interfaces defined inside Fragments
- **Passing Data to Fragments:** Using Bundle and setArguments()
- **UI Listeners:** setOnCheckedChangeListener for CheckBox
- **Fragment Management:** FragmentManager and FragmentTransaction

app/src/main/java/com/example/myapplication/
├── MainActivity.java
├── Fragment1.java
├── Fragment2.java
└── Fragment3.java
app/src/main/res/layout/
├── activity_main.xml
├── fragment_1.xml
├── fragment_2.xml
└── fragment_3.xml

---

## 🚀 How to Run
1. Clone the repository
2. Open the project in Android Studio
3. Run the app on an emulator or physical device

---

## 📁 Project Structure
