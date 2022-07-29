# Digi-Template-Android
Template project for Android Version 0.0.1

Gradle
- Project Level
    - Declare environment setup
        - Base Url
        - Asset Url
        - Key
        - etc

- Module Level
    - Create build types (Default is development and production)
        - debug
            - set package name {package_name}.debug -> so it has different package with the release version
            - set environment from development
        - release
            - set environment to production
            - set minifyEnabled
            - set proguard rules
Notes : Please add another build types depends on requirement and needs

View Binding
- Use view binding in each module to ease development

Modules
- We use multi modules in each project
- Each project must have 3 modules for minimum
    - app (main module) -> required
    - digiuikit (custom component, ui library, color, strings, etc) -> required
        - library for UI
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

MVVM
- MVVM is the preferred design pattern
- each module has its own mvvm implementation
- preferred package structure
    - app
        - di
        - ui
            - activity
            - fragment
            - adapter
        - viewmodel
    - data
        - mappers (map server data model to domain model (ui model))
        - models (server data model)
        - repository (domain's repository implementation)
        - service
    - domain
        - models (UI model)
        - repositories (interfacec)
        - usecases (business logic, mediator between viewmodel and repository)
    - util/common
- use LiveData for communication between activity/fragment with viewmodel
- use RxJava/Coroutines for api request or room
- use dependency injection = dagger hilt

Sqlite
- use Room from Android Jetpack

Proguard
- used before release
- All release product must implement proguard

Splash scree
- use androidx splash screen API

DELETE ALL LOG BEFORE RELEASE A PRODUCT!!!
