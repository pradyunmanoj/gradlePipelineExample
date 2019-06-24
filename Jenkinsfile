pipeline {

    agent any

    options {

        disableConcurrentBuilds()

    }

    stages {

        stage('Gradle Build') {

            steps {

                bat 'gradle.bat clean build'

            }

        }

        stage('Gradle Test') {

            steps {

                bat 'gradle.bat clean test'

            }
        }

        stage('Gradle Building Deployment Artifacts') {

            steps {

                bat 'gradle.bat clean stage'

            }
        }

    }

}