# Digi-Template-Android
Template project for Android

Gradle
#Project Level
    - Declare environment setup
        - Base Url
        - Asset Url
        - Key
        - etc

#Module Level
    - Create build types (Default is development and production)
        - debug
            - set package name {package_name}.debug -> so it has different package with the release version
            - set environment from development
        - release
            - set environment to production
            - set minifyEnabled
            - set proguard rules
    Notes : Please add another build types depends on requirement and needs

#View Binding
    - Use view binding in each module to ease development

#Modules
    - We use multi modules in each project
    - Each project must have 3 modules for minimum
        - app (main module) -> required
        - digiuikit (custom component, ui library, color, strings, etc) -> required
            - librarty for UI
            - custom UI component
            - reusable color
            - reusable asset/drawable
            - font
            - dimens
        - digicore (navigation, shared pref, reusable library, common utils, etc) -> required
            - use PrefUtils to save/read shared pref
            - use AppNavigation to navigate between module/feature
        - featureA
        - featureB
        - featureC
        - etc

#MVVM

#Sqlite
    - use Room from Android Jetpack
