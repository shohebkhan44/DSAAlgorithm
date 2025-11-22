param(
    [string]$Class = "LinkedLiastMedium"
)

# Compile the specified class only and run it
$javac = "javac"
$java = "java"

Write-Host "Compiling $Class.java..."
& $javac "$Class.java"
if ($LASTEXITCODE -ne 0) {
    Write-Error "Compilation failed. See errors above."
    exit $LASTEXITCODE
}

Write-Host "Running $Class..."
& $java $Class

exit $LASTEXITCODE
