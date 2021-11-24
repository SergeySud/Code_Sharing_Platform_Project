# Code_sharing_platform
A web app for storing code snippets.

POST `/api/code/new` and GET `/code/new` allow adding new snippets.

GET `/code/*{uuid}*` and GET `/api/code/*{uuid}*` allow finding snippets by UUID.

GET `api/code/latest` and GET `code/latest` show last 10 public snippets.
