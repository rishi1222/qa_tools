#!/usr/bin/env groovy
pipeline {
    agent {
        kubernetes {
            cloud 'openshift'
            label "jdk-maven${env.BUILD_ID}"
            defaultContainer 'jnlp'
            yaml """
    apiVersion: v1
    kind: Pod
    metadata:
      labels:
        app: jenkins
    spec:
      securityContext:
        runAsUser: 1000
      containers:
        - name: jnlp
          image: docker-registry.svc.uk.paas.intranet.db.com/fabric-community-images/fabric-jenkins-slave:2.7
          command:
          - /usr/local/bin/run-jnlp-client
          env:
            - name: HTTPS_PROXY
              value: http://dev-net-proxy.intranet.db.com:8080
          resources:
            limits:
              memory: 1000Mi
            requests:
              memory: 250Mi
              cpu: 200m
        - name: jdk-maven
          image: docker-registry.default.svc:5000/dk0905-a/jdk-maven:latest
          command: ['cat']
          tty: true
          env:
            - name: HTTPS_PROXY
              value: http://dev-net-proxy.intranet.db.com:8080
"""
        }
    }
    
        stages {

            stage ( "Env" ) {
                steps {
                    sh "env"
                }
            }



            stage ("E2E Tests") {
                steps {
                        container( name: "jdk-maven", shell: "/bin/bash" ) {
                            sh "mvn test -P sit"
                        }

                }
            }
        }


            post {
                    always {
                        script {
                             if (env.BRANCH_NAME == 'master'){
                                     archive (includes: 'target/cucumber-reports/*')
                                     publishHTML (target: [
                                       allowMissing: false,
                                       alwaysLinkToLastBuild: false,
                                       keepAll: true,
                                       reportDir: 'target/cucumber-reports',
                                       reportFiles: 'cucumber-html-reports/overview-features.html',
                                       reportName: "CucumberReport"
                                     ])
                             }
                        }
                    }
                     success {
                                        script{
                                              if (env.BRANCH_NAME == 'master'){
                                                        env.ForEmailPlugin = env.WORKSPACE
                                                        emailext(mimeType: 'text/html',
                                                        body: '''<!DOCTYPE html>
                                                                 <html>
                                                                 <b>
                                                                 <p style="color:green;" > CAT Regression Test Completed Successfully </p>
                                                                 </b>
                                                                 <p> For More Detail Please Click on link below </p>
                                                                 <p> http://jenkins-dk0905-a.uki1f.paas.intranet.db.com/job/TSP/job/qa_tools/job/master/CucumberReport/ </p>
                                                                 </html>''',
                                                        subject: currentBuild.currentResult + " : " + env.JOB_NAME,
                                                        to: 'rishi.kapoor@db.com, james.winter@db.com, swapnil-raghunathrao.bhosale@db.com'
                                                        )
                                              }
                                        }

                     }
                     failure {
                                                             script{
                                                                  if (env.BRANCH_NAME == 'master'){
                                                                             env.ForEmailPlugin = env.WORKSPACE
                                                                             emailext(mimeType: 'text/html',
                                                                             body: '''<!DOCTYPE html>
                                                                             <html>
                                                                                <b>
                                                                                <p style="color:red";> CAT Regression Test Failed </p>
                                                                                </b>
                                                                                <p> Please click on link below for more detail </p>
                                                                                <p> http://jenkins-dk0905-a.uki1f.paas.intranet.db.com/job/TSP/job/qa_tools/job/master/CucumberReport/ </p>
                                                                             </html>''',
                                                                             subject: currentBuild.currentResult + " : " + env.JOB_NAME,
                                                                             to: 'rishi.kapoor@db.com, james.winter@db.com, swapnil-raghunathrao.bhosale@db.com'
                                                                             )
                                                                  }

                                                             }

                                          }


        }
    }
