# Carousel and List

Android project built in both **Jetpack Compose** and **XML (View System)**. Both versions share a clean MVVM architecture powered by Dagger Hilt.

---

### Tech Stack
* **Language:** Kotlin + Coroutines/StateFlow.
* **DI:** Dagger Hilt
* **Build System:** Gradle with Version Catalog (`libs.versions.toml`).
* **UI Frameworks:**
    * **XML:** `ViewPager2`, `RecyclerView` (with `ListAdapter`), `CoordinatorLayout`.
    * **Compose:** `HorizontalPager`, `Scaffold`, `ModalBottomSheet`.

---

### Key Implementations
* Carousel with Indicator: Image slider with rounded corners and reactive circle indicators.
* Search Bar: Real-time filtering of both carousel and list using StateFlow.
* Item List: High-performance list with DiffUtil animations and rounded images.
* FAB & Bottom Sheet: Floating button triggering a stats sheet that calculates the most frequent characters.

---

### Setup & Installation

1. **Clone the Repo**
   ```bash
   git clone [https://github.com/Zhasulan66/CarouselAndList.git](https://github.com/Zhasulan66/CarouselAndList.git)