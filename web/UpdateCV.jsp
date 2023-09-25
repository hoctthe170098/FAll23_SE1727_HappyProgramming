<!DOCTYPE html>
<html>
<head>
    <title>CV Update</title>
</head>
<body>
    <h1>CV Update</h1>
    <form action="update-cv" method="post">
        <label for="fullName">Full Name:</label>
        <input type="text" id="fullName" name="fullName" value="${cvData.fullName}" required>
        <br>
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" value="${cvData.email}" required>
        <br>
        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone" value="${cvData.phone}" required>
        <br>
        <label for="education">Address</label>
        <textarea id="Address" name="Address" required>${cvData.Address}</textarea>
        <br>
        <label for="experience">Skills</label>
        <textarea id="Skills" name="Skills" required>${cvData.Skills}</textarea>
        <br>
        <button type="submit">Update</button>
    </form>
</body>
</html>
