<!doctype html>

<html lang="en">

<head>
    <meta charset="utf-8">

    <title>The HTMggL5 Herald</title>
    <meta name="description" content="The HTML5 Herald">
    <meta name="author" content="SitePoint">

    <link rel="stylesheet" href="css/styles.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col">
                <div class="form">
                    <form method=POST action="">
                        <fieldset>
                            <label for="uname"><b>Username</b></label>
                            <input type="text" placeholder="Enter Username" name="uname" required>
                            <br />
                            <label for="pwd"><b>Password</b></label>
                            <input type="password" placeholder="Enter Username" name="pwd" required>
                            <br/>
                            <button type="submit" class="btn btn-primary">Login</button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
<script>setTimeout(function () {
        location.reload();
    }, 3000);</script>

</html>