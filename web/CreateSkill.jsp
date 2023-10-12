<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Create new skill</title>
    <style>
        
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f0f0f0;
        }

        h1 {
            text-align: center;
        }

        form {
            max-width: 500px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        input[type="text"],
        input[type="file"],
        textarea {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        textarea {
            height: 100px;
        }

        input[type="submit"] {
            background-color: #007bff;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Create new skill</h1>
    <form action="createskill" method="post" enctype="multipart/form-data">
        <label for="skillName">Skill Name:</label>
        <input type="text" id="skillName" name="skillName" required><br><br>

        <label for="skillImage">Image:</label>
        <input type="file" id="skillImage" name="skillImage" accept="image/*" required>


        <label for="skillDescription">Desc:</label><br>
        <textarea id="skillDescription" name="skillDescription" rows="4" required></textarea><br><br>

        <input type="submit" value="Create">
    </form>
</body>
</html>