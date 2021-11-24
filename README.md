# Code_sharing_platform
A web app for storing code snippets.

POST `/api/code/new` and GET `/code/new` allow to add new snippets.

GET `/code/*{uuid}*` and GET `/api/code/*{uuid}*` allow to find snippets by UUID.

GET `api/code/latest` and GET `code/latest` show last 10 public snippets.
