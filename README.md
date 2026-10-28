# NutriSense — Android Application Development Assignment 2

NutriSense is a beginner-friendly Android application built with **Java and XML layouts**.

## Features
- Splash/welcome screen
- Login with email and password validation
- Registration with name, email, password and confirm password validation
- Simulated local password recovery and reset
- Dashboard with GridLayout cards for nutrition modules
- Profile screen showing the saved name and email
- Logout navigation
- Explicit Intents between Activities
- LinearLayout, GridLayout and ConstraintLayout examples
- Default colors and night-mode color resources
- Local demo account storage using SharedPreferences

## Demo login
- Email: `demo@nutrisense.com`
- Password: `123456`

You can also register a local account. Authentication and password recovery are simulated locally; there is no backend or email delivery.

## Navigation flow
Welcome → Login → Dashboard → Module details  
Login → Register → Login  
Login → Forgot Password → Reset Password → Login  
Dashboard → Profile → Logout → Login

## Open the project
1. Open Android Studio.
2. Select **Open** and choose the `NutriSense` project folder.
3. Allow Gradle sync to finish.
4. Run the app on an Android emulator or device.

## Technical note
The project uses Android Gradle Plugin 8.7.3, Java 11, compile SDK 35 and minimum SDK 23. Android Studio may ask to install the matching Android SDK platform.
