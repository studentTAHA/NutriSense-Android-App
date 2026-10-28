# NutriSense – Android App (Java + XML)

**Mobile Application Development – Assignment 2**
Muhammad Taha Mohsin · BS Artificial Intelligence · SZABIST Islamabad

NutriSense is a nutrition and wellness Android app built with **Java** and **XML layouts**. It demonstrates a complete authentication flow (splash, login, register, forgot/reset password), a dashboard of module cards, and a profile screen with logout. Authentication is simulated locally, so no backend is needed.

## Features

- **Splash / Welcome screen** with app name and tagline, leading to Login
- **Login** with email and password, input validation, and links to Register and Forgot Password
- **Register** with name, email, password and confirm password validation
- **Forgot Password** that accepts an email and starts a simulated recovery
- **Reset Password** with new password and confirm password validation
- **Dashboard** showing 6 nutrition modules as a grid of cards with icon and text
- **Module details** screen opened from each dashboard card
- **Profile** screen showing the user's name and email, with **Logout**
- **Light and dark mode** support through alternative night-mode resources
- Local account storage using `SharedPreferences`

## Navigation Flow

```
Welcome → Login → Dashboard → Module Details
                ↘ Register → Login
                ↘ Forgot Password → Reset Password → Login
Dashboard → Profile → Logout → Login
```

## Screens and Files

| Screen | Activity | Layout |
|---|---|---|
| Welcome | `MainActivity` | `activity_main.xml` (ConstraintLayout) |
| Login | `LoginActivity` | `activity_login.xml` (LinearLayout) |
| Register | `RegisterActivity` | `activity_register.xml` (LinearLayout) |
| Forgot Password | `ForgotPasswordActivity` | `activity_forgot_password.xml` |
| Reset Password | `ResetPasswordActivity` | `activity_reset_password.xml` |
| Dashboard | `DashboardActivity` | `activity_dashboard.xml` (GridLayout) |
| Module Details | `ModuleActivity` | `activity_module.xml` |
| Profile | `ProfileActivity` | `activity_profile.xml` |

## Technical Requirements Covered

- **Resources:** default `strings.xml` and `colors.xml`, plus alternative `values-night/colors.xml` and `values-night/styles.xml` for dark mode
- **Layouts:** `LinearLayout`, `GridLayout` and `ConstraintLayout`
- **Input controls:** `textEmailAddress`, `textPassword` and `textPersonName` input types
- **Button clicks and validation:** `setOnClickListener` with `setError` messages and Toasts
- **Navigation:** explicit Intents (`new Intent(this, X.class)`) between Activities
- **Consistent UI:** shared colors, styles and card background across all screens

## Demo Credentials

- Email: `demo@nutrisense.com`
- Password: `123456`

You can also register a new local account. Recovery and login are simulated; no email is sent.

## Screenshots

| Welcome | Login | Register |
|---|---|---|
| ![Welcome](screenshots/welcome.png) | ![Login](screenshots/login.png) | ![Register](screenshots/register.png) |

| Forgot Password | Reset Password | Dashboard |
|---|---|---|
| ![Forgot](screenshots/forgot.png) | ![Reset](screenshots/reset.png) | ![Dashboard](screenshots/dashboard.png) |

| Profile | Dashboard (Dark Mode) |
|---|---|
| ![Profile](screenshots/profile.png) | ![Dark](screenshots/dashboard_dark.png) |

## How to Run

1. Clone the repository: `git clone https://github.com/studentTAHA/NutriSense---Android-App.git`
2. Open the folder in **Android Studio** and let Gradle sync finish
3. Run the app on an emulator or a physical device

## Tech Stack

Java 11 · XML · Android Gradle Plugin 8.7.3 · Compile SDK 35 · Min SDK 23
