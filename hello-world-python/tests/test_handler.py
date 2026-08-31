import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parents[1] / "src"))

from index import handler


def test_handler_returns_200():
    response = handler({}, None)
    assert response["statusCode"] == 200
    assert "Python" in response["body"]
