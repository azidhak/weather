# weather

Weather is an application that show you current and tomorrow's forecast information of Stockholm, Gothenburg, Mount view, London, New york, Berlin and Malmo. It use https://open-meteo.com/en free API to get forecast data.

### Highlights
- Kotlin.
- MVVM.
- Clean architecture.
- Retrofit.
- Coroutine.
- Compose.
- Hilt.

### Libraries
    implementation 'androidx.core:core-ktx:1.8.0'
    implementation "androidx.compose.ui:ui:$compose_version"
    implementation "androidx.compose.material:material:$compose_version"
    implementation "androidx.compose.ui:ui-tooling-preview:$compose_version"
    implementation 'androidx.lifecycle:lifecycle-runtime-ktx:2.5.1'
    implementation 'androidx.activity:activity-compose:1.5.1'
    implementation 'androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1'
    
    // Retrofit
    implementation 'com.squareup.retrofit2:retrofit:2.9.0'
    implementation 'com.squareup.retrofit2:converter-moshi:2.9.0'
    
    //Dagger - Hilt
    implementation 'com.google.dagger:hilt-android:2.43.1'
    kapt 'com.google.dagger:hilt-android-compiler:2.43.1'
    kapt 'androidx.hilt:hilt-compiler:1.0.0'
    implementation 'androidx.hilt:hilt-navigation-compose:1.0.0'
    
    //Test
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.3'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.4.0'
    androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_version"
    debugImplementation "androidx.compose.ui:ui-tooling:$compose_version"
    testImplementation 'org.mockito:mockito-core:4.7.0'
    testImplementation 'org.mockito.kotlin:mockito-kotlin:4.0.0'
    testImplementation 'org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.1'
    androidTestImplementation "androidx.compose.ui:ui-test-junit4:$compose_version"
    debugImplementation "androidx.compose.ui:ui-test-manifest:$compose_version"
