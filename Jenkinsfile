pipeline {

    agent any

    options {

        disableConcurrentBuilds()

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