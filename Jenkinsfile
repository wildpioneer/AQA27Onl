pipeline {
    agent any

    tools {
        // Install the Maven version configured as "M3" and add it to the path.
        maven "M3"
    }

    parameters {
        gitParameter branchFilter: 'origin/(.*)', defaultValue: 'ci_cd', name: 'BRANCH', type: 'PT_BRANCH'
    }

    stages {
        stage('Checkout') {
            steps {
                // Get some code from a GitHub repository
                git branch: "${params.BRANCH}", url: 'https://github.com/wildpioneer/AQA27Onl.git'
            }
        }
        stage('Test') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn clean test"

                // To run Maven on a Windows agent, use
                // bat "mvn clean test"
            }
        }
    }
}