so to test we use Junit annotate the functions with @Test to make it a testable ensure that the importing is done correctly
mvn test
mvn clean test
to test the test cases

jenkins 
so configure the jenkins
MAVEN in tools to be added to enable mvn commands inside the pipeline
to enable mail ensure that the you can refer a youtube video to make that thing work
pipeline {
agent any

    tools {
        maven 'MAVEN_3'
    }

    triggers {
        pollSCM('H/5 * * * *')
    }

    stages {

        stage("Checkout") {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Gokulashik22014/java_jenkins_testing.git'
            }
        }

        stage("Build and Test") {
            steps {
                bat 'mvn clean test'
            }
        }

    }

    post {
        success {
            mail to: 'gokulashik222@gmail.com',
                subject: "TESTS PASSED 🎯 — ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
Good news — all tests passed.

Project : ${env.JOB_NAME}
Build   : ${env.BUILD_URL}
Branch  : main
"""
}

        failure {
            mail to: 'gokulashik222@gmail.com',
                subject: "TESTS FAILED ❌ — ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
Tests failed. Review the logs and fix the issues before merging.

Project : ${env.JOB_NAME}
Build   : ${env.BUILD_URL}
Branch  : main
"""
}
}
}
