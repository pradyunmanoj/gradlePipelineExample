pipeline {

    agent any

    options {

        disableConcurrentBuilds()

    }

    stages {

        stage('Gradle Build') {
            tools {
                jdk "jdk-9.0.1"
            }
            steps {

                bat 'gradlew.bat clean build'

            }

        }

        stage('Gradle Test') {
            tools {
                            jdk "jdk-9.0.1"
                        }
            steps {

                bat 'gradlew.bat clean test'

            }
        }

        stage('Gradle Building Deployment Artifacts') {
            tools {
                            jdk "jdk-9.0.1"
                        }
            steps {

                bat 'gradlew.bat clean stage'

            }
        }

    }

}