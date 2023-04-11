node {
  stage("Clone the project") {
    git branch: 'main', url: 'https://github.com/jc-773/sbws_backend'
  }

  stage("Compilation") {
    sh "./mvnw clean install -DskipTests"
  }