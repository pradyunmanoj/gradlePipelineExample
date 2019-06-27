


    pipeline {

    agent any

    options {

        disableConcurrentBuilds()

    }

    tools {
        jdk 'JAVA_HOME'
    }

    stages {

            stage('Gradle Build') {

                steps {

                    bat 'gradlew.bat clean build'

                }

            }

            stage('Gradle Test') {

                steps {

                    bat 'gradlew.bat clean test'

                }
            }

            stage('Gradle Building Deployment Artifacts') {

                steps {

                    bat 'gradlew.bat clean publish'

                }
            }

        }
}