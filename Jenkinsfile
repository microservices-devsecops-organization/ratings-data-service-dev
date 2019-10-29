pipeline {

    agent any

    // Set Maven as tool build
    tools { 
        maven 'Maven 3.3.9' 
        jdk 'jdk8' 
    }

    environment {
        PROJECT_NAME = 'ratings-data-service'
        NEXUS_REPOSITORY = "${PROJECT_NAME}" 
        NEXUS_PROJECT_SOURCE = "${PROJECT_NAME}/target" 
        NEXUS_FILE = "${NEXUS_PROJECT_SOURCE}/ratings-data-service-0.0.1-SNAPSHOT.jar" 
        HARBOR_PROJECT = "${PROJECT_NAME}" 
        HARBOR_IMAGE = "${PROJECT_NAME}-img" 
        SONAR_PROJECT_KEY = "${PROJECT_NAME}" 
        SONAR_PROJECT_NAME = "${PROJECT_NAME}" 
        SONAR_PROJECT_SOURCE = "${NEXUS_PROJECT_SOURCE}" 
    }

    // Import Shared Library source
    libraries {
        lib('my-shared-lib@master')
    }

    options {
        // Update status to Gitlab
        gitLabConnection('Gitlab-Connection')
    }

    stages {
        stage('Build & Tests') {
            steps {
                // IMPORT BY SHARED LIBRARY
                mavenSharedLib()
            }
        }

        stage('Code Quality') {
            steps {
                // IMPORT BY SHARED LIBRARY
                sonarqubeSharedLib()
            }
        }

        stage("Repository Artifacts") {
            parallel {
                stage("Publish to Nexus") {
                    steps {
                        // IMPORT BY SHARED LIBRARY
                            nexusSharedLib()
                    }
                }
                stage("Publish to Harbor") {
                    steps {
                        // IMPORT BY SHARED LIBRARY
                        harborSharedLib()
                    }
                }
            }
        }

        stage('Deploy QA') {
            input {
                message "Approve deploy? (QA Env)"
            }       
            steps {
                // IMPORT BY SHARED LIBRARY
                kubernetesQASharedLib()
            }
        }
    }
}
