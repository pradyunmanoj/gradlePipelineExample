pipeline {

    agent any

    options {

        disableConcurrentBuilds()

    }

    stages {

        stage('Gradle Build') {

            steps {

                bat 'gradle clean build'

            }

        }

        stage('Gradle Test') {

            steps {

                bat 'gradle clean test'

            }
        }

        stage('Gradle Building Deployment Artifacts') {

            steps {

                bat 'gradle clean stage'

            }
        }

    }

}