##git pull 的出现如下错误：
- Your local changes to the following files would be overwritten by merge

- 本地的代码和服务器代码发生冲突：
    - 两者合并
  ```
  git stash
  git pull
  git stash pop
  ```
    - 代码库覆盖本地：
  ```
  git reset --hard
  git pull
  ```