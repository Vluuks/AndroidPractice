import check50

@check50.check()
def exists():
    """mario.py exists."""
    check50.exists("StudentTest.java")

@check50.check(exists)
def compiles():
    """no syntax errors in mario.py."""
    check50.run("javac StudentTest.java").exit(0)

# @check50.check(compiles)
# def prints_four_question_marks():
#     """prints running main w/o runtime errors"""
#     check50.run("java StudentTest.java").stdout("Running main!", "Running main!\n").exit(0)
