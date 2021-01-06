#!/home/carson/.rvm/rubies/ruby-2.6.2/bin/ruby -w

require 'octokit'
require 'csv'

# =====================================================================
#  github setup
# =====================================================================
git_token = ENV["GITHUB_TOKEN"]
unless git_token
  throw "You must set the GITHUB_TOKEN environment variable"
end
client = Octokit::Client.new(:access_token => git_token)
client.auto_paginate = true
user = client.user
git_username = user.login
class_repo_name = "msu/csci-440-fall2020"
class_repo_url = "https://github.com/#{class_repo_name}"
puts("github user id: #{user.login}")

# =====================================================================
#  helper functions
# =====================================================================
def each_student_dir(path)
  Dir.foreach(path) do |filename|
    next unless filename.end_with? "txt"
    dir_name = filename.split(/[.,]/)[0]
    destination = "#{path}/student_repos/#{dir_name}"
    if File.directory? destination
      yield destination
    else
      puts "Directory #{destination} does not exist, can't test"
    end
  end
end

def each_student
  results = CSV.read("students.csv", headers: true)
  results.each do |row|
    yield row
  end
end

def student_dir(student)
  student["FIRST_NAME"].downcase + "_" + student["LAST_NAME"].downcase
end

# =====================================================================
#  command line
# =====================================================================

case ARGV[0]
when "accept_pull_requests"
  puts("Accepting Pull Requests")
  puts("------------------")
  repo = client.repo(class_repo_name)
  client.pull_requests(repo[:id]).each do |pr|
    puts "  Merging #{pr[:id]} - #{pr[:number]}: #{pr[:head][:repo][:full_name]}"
    client.merge_pull_request(repo[:id], pr[:number])
  end
when "init_repos"
  each_student do |student|
    dir = "repos/#{student_dir(student)}"
    puts "Initializing #{student['FIRST_NAME']} #{student['LAST_NAME']} in #{dir}"
    if File.file? dir + "/grading/autograde.rb"
      puts "Already initialized..."
    else
      puts
      `cd #{dir};
       git pull #{class_repo_url} master;
      `
    end
  end
when "accept_invites"
  puts("Accepting Repository Invites")
  puts("------------------")
  client.user_repository_invitations.each do |ri|
    puts "  Accepting #{ri[:id]}: #{ri[:repository][:full_name]}"
    client.accept_repo_invitation(ri[:id])
  end
when "grade"
  assignment = ARGV[1]
  if assignment == "hwk4"
    each_student do |student|
      dir = "repos/#{student_dir(student)}"
      puts "Grading #{student['FIRST_NAME']} #{student['LAST_NAME']} in #{dir}"
      puts
      `mkdir -p #{dir}/grading/;
             cd #{dir};
             mvn -Dtest=Homework4 test > grading/homework_4.txt 2> err.out;
             git add grading/*;
             git commit -m "From Autograder"
             git push`
    end
  elsif assignment == "project"
    each_student do |student|
      dir = "repos/#{student_dir(student)}"
      puts "Grading #{student['FIRST_NAME']} #{student['LAST_NAME']} in #{dir}"
      puts
      `mkdir -p #{dir}/grading/;
             cd #{dir};
             mvn "-Dtest=edu.montana.csci.csci440.model.*Test" test > grading/project.txt 2> err.out;
             git add grading/*;
             git commit -m "From Autograder"
             git push`
    end
  else
    puts "Unknown assignment: #{assignment}"
  end
when "clone_repos"
  each_student do |student|
    repo_url = student["REPO"]
    `git clone https://#{git_username}:#{git_token}@#{repo_url} repos/#{student_dir(student)}`
  end
when "clear_repos"
  `rm -rf repos`
else
  puts "Commands:
    accept_invites - accepts pending invites
    clone_repos - clones student repos to the repos directory
    clear_repos - removes all repos from the current dir
    grade <assignment> - grades the given assignment and pushes it"
end
