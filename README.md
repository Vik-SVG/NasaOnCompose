# NasaOnCompose

Nasa open API using latest libraries with Clean Arch and Jetpack Compose. 

The buildSrc is responsible for dependency management.
It controls and manages all dependencies in one place with Kotlin DSL. In Dependencies.kt there are list of common Android libraries that come in handy.

The project implements clean architecture and consists of next components:

1. Data layer.
Used for getting data from local and remote storages. Datasource implements logic for safe data parsing and return Resource data object. 
There is 3 types of data source: remote, local, cached. Repository handles which data should be cached or saved locally.

2. Domain layer.
Handled data before presenting it to user via UseCases.

3. Presentation layer.
Implemented with feature modules, which keep all consumer related code.

4. Core.
Logic which is shared among all other modules. However, core module can not have any reference to outer modules. 

Base logic implemented with delegates instead of inheritance to reduce dependency between classes.  


![Screenshot_20231026-174823](https://github.com/Vik-SVG/NasaOnCompose/assets/52634082/9a84f03f-e043-4221-83f8-43a99e836b6a)

![Screenshot_20231026-150745](https://github.com/Vik-SVG/NasaOnCompose/assets/52634082/a8026416-cfd7-4a9e-819d-864734749037)

![Screenshot_20231026-150727](https://github.com/Vik-SVG/NasaOnCompose/assets/52634082/72e5d699-ae2f-458b-92bc-fb7a84fa929a)
