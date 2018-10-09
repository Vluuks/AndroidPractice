import check50

@check50.check()
def exists():
    """mario.py exists."""
    check50.exists("StudentTest.java")

@check50.check(exists)
def compiles():
    """no syntax errors in mario.py."""
    check50.run("javac StudentTest.java").exit(0)

