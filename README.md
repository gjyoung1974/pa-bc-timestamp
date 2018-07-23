# Privacy Aware Block Chain logging RFC3161 pki timestamp service TSP as Java HTTPServlet

#### My first attempt at a    
Privacy Aware Block Chain Logging    
RFC3161 PKI TimeStamp Service

**How to test it?**

    RFC3161 was originaly slated for use with MSFT Authenticode. 
    Anything that can handle the cryptographic primitives had HTTP Transport will work     
    Here we weill use OpenSSL to generate a TSP Request and parse the repponse   
    simply to test the servlet...


1. Create the file you will want to timestamp

```bash
$ touch inputfile.txt    
$ cat aasdfasdf >> inputfile.txt    
```
^^ This is my test file.

1. Generate a timestamp request

```$bash
$ openssl ts -query -data inputfile.txt -cert -sha256 -no_nonce -out request.tsq
```
 

3. Send the request to your timestamp server

```$bash
$ curl -k -H “Content-Type: application/timestamp-query” -H Host:timestamp.globalsign.com –data-binary @request.tsq “http://timestamp.globalsign.com”  >inputfile.txt.tsr
```

 

4. Verify the timestamp response

```$bash
$ openssl ts -reply -in inputfile.txt.tsr -text
```

This is going to give you some output that looks something like this:

 
```$bash

Using configuration from /usr/share/openssl/bin/openssl.cfg

Status info:

Status: Granted.

Status description: unspecified

Failure info: unspecified

TST info:

Version: 1

Policy OID: 1.3.6.1.4.1.4146.2.2

Hash Algorithm: sha256

Message data:

    0000 – 58 df 63 8c 5b bf ff ca-ad 13 c9 6e 93 96 cd 25   X.c.[……n…%

    0010 – 66 5e f1 eb ba 8e 7f 74-6d 65 04 3c 5d ea e4 35   f^…..tme.<]..5

Serial number: 0x2487F5EA8A5A085844ED68A8A7426E07E692E1BD

Time stamp: Sep 17 05:08:38 2013 GMT

Accuracy: unspecified

Ordering: no

Nonce: unspecified

TSA: DirName:/C=SG/O=GMO GlobalSign Pte Ltd/CN=GlobalSign TSA for Standard – G1

Extensions:

```


```
2018 Gordon Young gjyoung1974@gmail.com
```

