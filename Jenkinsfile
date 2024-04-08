pipeline{
    agent any // run this pipeline any where
    tools{
        maven "maven"
    }
    stages{
        
        stage("SCM checkout"){
            steps{
                checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/thalarikalyan/JRPT_FileDownloadExcelPdf.git']])
            }
        }
        stage("Build Process"){
            steps{
                script{
                    bat 'mvn clean install'
                }
            }
        }
         stage("Deploy to Container"){
            steps{
               deploy adapters: [tomcat9(credentialsId: 'admin_final_details', path: '', url: 'http://localhost:8888/')], contextPath: 'JRPT_FileDownloadExcelPDF', war: '**/*.war'
            }
        }
        
    }
    post{
        always{
            emailext attachLog: true, body: '''<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Build Status</title>
<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-color: #f4f4f4;
    }
    .container {
        max-width: 600px;
        margin: 50px auto;
        background-color: #fff;
        border-radius: 5px;
        padding: 20px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    h1 {
        color: #333;
        text-align: center;
    }
    .status {
        text-align: center;
        margin-top: 30px;
    }
    .success {
        color: green;
    }
    .failure {
        color: red;
    }
</style>
</head>
<body>
<div class="container">
    <h1>Build Status</h1>
    <div class="status">
        <p>Build Status : <span class="success">Build Status : ${BUILD_STATUS}</span></p>
        <p>Pipeline status : <span class="success">Pipeline status : ${BUILD_NUMBER}</span></p>
    </div>
    <p>Thanks,<br>Bhagyamma</p>
</div>
</body>
</html>
''', mimeType: 'text/html', replyTo: 'thalarikalyaninfo@gmai.com', subject: 'PipeLineStatus : ${BUILD_NUMBER}', to: 'thalarikalyaninfo@gmail.com'
        }
        }
    }

//SCM checkout
//Build
//deploy
//email
