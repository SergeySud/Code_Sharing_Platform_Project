import pytest
import requests

ID = "7188bd70-c0e4-4370-b9d7-3a7cab6f7c81"
CODE = "print('Hello, world!')"
SERVER = "http://localhost:8889"


def test_server_status():
    response = requests.get(SERVER + "/hello")
    assert response.status_code == 200


def test_get_hello():
    response: str = requests.get(SERVER + "/hello").text
    assert "Hello!" in response


def test_post_code():
    response = requests.post(SERVER + "/api/code/new", json={"code": CODE})
    assert response.status_code == 200


def test_get_code():
    response = requests.get(SERVER + "/api/code/" + ID)
    code = response.text
    assert CODE in code
