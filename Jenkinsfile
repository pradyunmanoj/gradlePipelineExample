pipeline {

    agent any

    options {

        disableConcurrentBuilds()

    }

    tools {
        jdk 'jdk-9.0.1'
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

                bat 'gradlew.bat clean stage'

            }
        }

    }

}