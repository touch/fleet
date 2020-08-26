pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        sh 'lein install'
      }
    }
    stage ('deploy') {
      steps {
        sh 'lein deploy upstream'
      }
    }
  }
}