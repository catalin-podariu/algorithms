#!/bin/bash

# Create export directory if it doesn't exist
mkdir -p export

# Initialize counter
counter=1

# Step 1: Read template.json into a variable
if [[ ! -f "template.json" ]]; then
  echo "Error: template.json not found."
  exit 1
fi

template=$(<template.json)

# Step 2: Loop through each line of input.txt
if [[ ! -f "input.txt" ]]; then
  echo "Error: input.txt not found."
  exit 1
fi

while IFS= read -r line || [ -n "$line" ]; do
  # Remove unnecessary extra quotes and add escaped quotes around the IP
  transformed_line=$(echo "$line" | sed 's/"//g')
  transformed_line=$(echo "$transformed_line" | sed -E 's/([0-9]+\.[0-9]+\.[0-9]+\.[0-9]+)/\\\\"&\\\\"/g')

  # Step 3: Extract title and query
  title=$(echo "$transformed_line" | cut -d';' -f1)
  query=$(echo "$transformed_line" | cut -d';' -f2)

  # Step 4: Validate that title and query are not empty
  if [[ -z "$title" || -z "$query" ]]; then
    echo "Invalid line: $line"
    continue
  fi

  # Step 5: Replace dummy values in the template
  modified_template=$(echo "$template" | sed "s/DUMMY_QUERY_TO_REPLACE/$query/g")
  modified_template=$(echo "$modified_template" | sed "s/DUMMY_TITLE_TO_REPLACE/$title/")

  # Step 6: Save into a new file with a counter
  new_filename="Cisco Firepower Firewall $title $counter.json"
  echo "$modified_template" > "export/$new_filename"

  # Debug: Print the current line
  echo "Processing line: $new_filename"

  # Increment counter
  ((counter++))
done < input.txt
