#!/bin/bash

# git status를 사용하여 새로 추가된 파일 목록을 가져옵니다.
# 새 파일은 '??' 상태로 표시됩니다.
NEW_FILES=$(git status --porcelain | grep '??' | cut -c4-)

# 새로 추가된 파일이 없으면 종료합니다.
if [ -z "$NEW_FILES" ]; then
  echo "No new files to add."
  exit 0
fi

# 새로 추가된 각 파일에 대해 반복합니다.
for FILE in $NEW_FILES; do
  # 파일명에서 폴더 이름을 추출합니다.
  FOLDER=$(basename $(dirname $FILE))

  # 파일을 git에 추가합니다.
  git add "$FILE"

  # 파일명에서 문제 번호와 설명을 추출하여 커밋 메시지를 생성합니다.
  BASENAME=$(basename $FILE)
  COMMIT_MESSAGE="feat: ${BASENAME%.*} 문제 풀이"
  git commit -m "$COMMIT_MESSAGE"
done

echo "All new files have been added and committed."
