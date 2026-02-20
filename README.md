# Simple Messenger (Android)

A simple text messaging Android application built with Kotlin and XML layouts.

## Features
- Basic chat-style interface using `RecyclerView`
- Message input box and send button
- In-memory conversation list
- Simulated auto-reply for demo behavior

## Project structure
- `app/src/main/java/com/example/simplemessenger/MainActivity.kt` — screen setup and send behavior
- `app/src/main/java/com/example/simplemessenger/MessageAdapter.kt` — chat list adapter
- `app/src/main/java/com/example/simplemessenger/Message.kt` — message model

## Run
1. Open the project in Android Studio.
2. Let Gradle sync.
3. Run the `app` module on an emulator or Android device.
