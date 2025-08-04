## 📱 Acronym Finder — Android App

A simple, fast, and beautiful Android application to search the **full form of any acronym** — now with a one-tap **Get Random Acronym** feature to help you explore acronyms even when you're not sure what you're looking for.

---

### 🎯 Features

* 🔍 **Search Any Acronym:** Enter an acronym (like "CPU") and instantly find its full form from the local SQLite database.
* 🎲 **Get Random Acronym:** Feeling curious? Tap the "Get Random Acronym" button to explore a randomly selected acronym from the database.
* ⚡ **Fast Offline Access:** All data is stored locally using SQLite — no internet required!
* 🧠 **Clean, Minimal UI:** Intuitive and aesthetically pleasing design that’s easy to navigate.

---

### 🧱 Tech Stack

| Component | Technology           |
| --------- | -------------------- |
| Language  | Java                 |
| Platform  | Android (XML + Java) |
| Database  | SQLite               |
| IDE       | Android Studio       |

---

### 🗂️ Database Schema

SQLite table used:

```sql
CREATE TABLE acronyms (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    acronym TEXT NOT NULL,
    fullform TEXT NOT NULL
);
```

> The `id` is used internally. Core operations rely on the `acronym` and `fullform` pair.

---

### 🖼️ User Interface Overview

| Screen                    | Description                                                                                 |
| ------------------------- | ------------------------------------------------------------------------------------------- |
| 🔤 **Input Field**        | Enter any acronym or tap the randomizer to populate the field.                              |
| 📘 **Find Full Form**     | Button that reveals the full form of the entered acronym.                                   |
| 🎲 **Get Random Acronym** | A new button that fetches a random acronym from the database and autofills the input field. |
| 📋 **Output Area**        | Displays the full form of the acronym in a readable, centered format.                       |

---

### 🚀 Getting Started

#### 1. Clone the repo

```bash
git clone https://github.com/yourusername/acronym-finder.git
```

#### 2. Open in Android Studio

* File → Open → Select project directory

#### 3. Run the app

* Plug in your device or use the emulator.
* Click **Run**.

---

### ✏️ Contributing

Found a bug? Want to add features like:

* Search suggestions
* Favorite acronyms
* Share feature
  Feel free to fork and contribute via pull requests.

---

### 📸 Screenshots

> <img width="1919" height="1032" alt="image" src="https://github.com/user-attachments/assets/5078ee01-708b-480d-9ff9-d7100004a26d" />


---

### 🧑‍💻 Author

**Ved Tripathi**
[[LinkedIn]([https://www.linkedin.com/in/ved-tripathi01/])]

---

### 📝 License

This project is open source under the [MIT License](LICENSE).

---
