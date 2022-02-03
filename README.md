# Code_sharing_platform
A web app for storing code snippets.

POST `/add` with JSON load `"url": *{url}*` allows adding new links.

GET `/*{uuid}*` redirects to the urls. 

GET `/all` shows all links. Requires user to be authenticated.

DELETE `/*{uuid}*` deletes the link.  Requires user to be authenticated.
