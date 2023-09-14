import pycurl
import certifi
from io import BytesIO
byteobj = BytesIO() #buffer creation
curlobj = pycurl.Curl()
curlobj.setopt(curlobj.URL, 'https://www.google.com/') #initializing the request URL
curlobj.setopt(curlobj.WRITEDATA, byteobj) ## Write bytes that are utf-8 encoded
curlobj.setopt(curlobj.CAINFO, certifi.where())
curlobj.perform() # perform file transfer
curlobj.close() # end of session
body = byteobj.getvalue()
print("GET REQUEST:")
print(body.decode('iso-8859-1'))