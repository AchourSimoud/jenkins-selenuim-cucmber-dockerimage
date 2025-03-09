pipeline {
    agent {
        docker {
            image 'selenium/standalone-chrome'
            args '--privileged -v /var/run/docker.sock:/var/run/docker.sock'  // Permet à Docker d'utiliser le socket de l'hôte
        }
    }

    parameters {
        string(name: 'TAG', defaultValue: 'run_login_tests_chrome', description: 'Tag to execute')
    }

    stages {
        stage('Install Dependencies') {
            steps {
                script {
                    // Installer Maven et Java dans le conteneur
                    sh '''
                    sudo apt-get update && \
                    sudo apt-get install -y maven openjdk-21-jdk
                    '''
                    
                    // Créer le répertoire cache de Selenium pour éviter les problèmes de permission
                    sh 'sudo mkdir -p /home/seluser/.cache/selenium'
                    sh 'sudo chmod -R 777 /home/seluser/.cache/selenium'
                }
            }
        }
        stage('Run Tests') {
            steps {
                script {
                    sh "chmod +x batch/*.sh"
                    sh "batch/${params.TAG}.sh"
                }
            }
        }
    }
    post {
        always {
            script {
                cucumber buildStatus: 'UNSTABLE',
                    failedFeaturesNumber: 1,
                    failedScenariosNumber: 1,
                    skippedStepsNumber: 1,
                    failedStepsNumber: 1,
                    classifications: [
                     [key: 'Commit', value: 'Commit ID non disponible'],
                       [key: 'Submitter', value: 'Nom du soumetteur non disponible']
                    ],
                    reportTitle: 'My report',
                    fileIncludePattern:  'reports/*.json',
                    sortingMethod: 'ALPHABETICAL',
                    trendsLimit: 100

                echo 'Tests finished. Check the console output for details!'
            }
        }
    }
}
