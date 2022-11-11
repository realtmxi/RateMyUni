package ControllerPresenter.Dictionaries;

public class ChinesePromptDictionary extends PromptDictionary {
    public ChinesePromptDictionary(){
        super();
        initiateLogInPrompts();
        initiateMainPrompts();
        initiateMenus();
        initiateUserOptionPrompts();
        initiateReviewPrompts();
        initiateInfoPrompts();

    }

    private void initiateInfoPrompts() {
        infoPromptsMap.put(PromptDictionary.infoPrompts.profileInfo,"这是<%s>的个人主页\n 毕业年份: %s\n 电子邮箱: %s\n 赞过的评论: %s\n");
        infoPromptsMap.put(PromptDictionary.infoPrompts.profInfo, "===[教授主页]===\n教授姓名: %s\n所属大学: %s\n所属院系: %s\n===[平均得分]===\n" +
                "总体平均得分: %s\n平均严格度: %s\n平均清晰度: " +
                "%s\n平均参与度: %s\n课程需要出席: %s%% 认同\n需要课本: %s%% 认同\n");
        infoPromptsMap.put(PromptDictionary.infoPrompts.profReviewInfo, "===[ %s在%s留下了此评论]===\n 评论ID: %s\n 教授姓名: %s\n 所授课程: %s\n 总体评分: %s\n 评语: %s\n 困难指数: %s\n " +
                "清晰度: %s\n 参与度: %s\n 课程需要出席(true: 是；false: 否）: %s\n 需要课本(true: 是；false: 否）: %s\n===[赞👍: %s, 踩👎:%s]===\n");
        infoPromptsMap.put(PromptDictionary.infoPrompts.courseInfo, "===[课程主页]===\n课程代码: %s\n所属大学: %s\n所属院系: %s\n===[平均得分]===\n" +
                "总体平均得分: %s\n平均难度: %s\n平均课业量: %s\n偏理论: %s%% 认同\n" +
                "偏实践: %s%% 认同\n氛围包容: %s%% 认同\n");
        infoPromptsMap.put(PromptDictionary.infoPrompts.courseReviewInfo, "===[%s在%s留下了此评论]===\n 评论ID: %s\n 课程代码: %s\n 总体评分: %s\n 评语: %s\n " +
                "课程难度: %s\n 课业量: %s\n 需要参与: %s\n 偏理论: %s\n 偏实践: %s\n 分为包容: %s\n===[赞👍: %s, 踩👎:%s]===\n");
        infoPromptsMap.put(PromptDictionary.infoPrompts.dormInfo, "===[宿舍主页]===\n宿舍楼名: %s\n所属大学: %s\n楼层: %s\n===[平均得分]===\n" +
                "总体平均得分: %s\n平均清洁度: %s\n平均社交氛围: " +
                "%s\n平均隔音效果: %s\n平均宿管得分: %s\n" +
                "平均饮食质量: %s\n平均便利度: %s\n平均网速: %s\n");
        infoPromptsMap.put(PromptDictionary.infoPrompts.dormReviewInfo,"===[%s在%s留下了此评论]===\n 评论ID: %s\n 宿舍楼名: %s\n 总体得分: %s\n 评语: %s\n 清洁度: %s\n 社交氛围: %s\n " +
                "隔音质量: %s\n 宿管质量: %s\n 食物质量: %s\n 便利程度: " +
                "%s\n 网速: %s\n===[赞👍: %s, 踩👎:%s]===\n");
    }

    public void initiateLogInPrompts(){
        logInPromptsMap.put(PromptDictionary.LogInPrompts.AskLogInOrCreateAccount,"欢迎来到登录界面. 你有以下选择: \n 1) 登录已有账号\n 2) 创建新的账号\n " +
                "请输入 1 或者 2.\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.AskQuit,"如果您想退出此程序，请键入 q。 否则，请按下任何其他键以继续。\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.LogInSuccess,"成功登录!\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.UserExists,"用户以存在，请登录而不是注册。\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.UserNameOrPasswordIncorrect,"用户名或密码不正确，请重试。\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.UserBanned,"用户账号被封，因此无法登录。\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.UserAlreadyLoggedIn,"用户已经登录!\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.SignUpSuccessful, "创建账户成功！您已自动登录。\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.LogOutSuccess, "登出成功，下次再见! :)\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.GetUsername, "请输入登录用户名:\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.GetPassword, "请输入登录密码:\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.GetUsernameSignUp, "请输入创建新用户的用户名:\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.GetPasswordSignUp, "请输入创建新用户的密码:\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.ForgetPassword, "忘记密码，需重设登录信息。\n");
        logInPromptsMap.put(PromptDictionary.LogInPrompts.UserNotExists, "用户不存在，请创建新账户。\n");
    }

    public void initiateMainPrompts(){
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichProf,"您想浏览哪位教授的评论？ 请输入教授的全名。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichCourse,"您想浏览哪门课程的评论？ 请输入课程代码。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichDorm,"您想浏览哪个宿舍的评论？ 请输入宿舍的全名。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichUni,"请输入您想搜索的大学的全名：\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichUniProf,"请输入此教授所属的大学：\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichUniCourse,"请输入提供该课程的大学：\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichUniDorm,"请输入该宿舍楼所属的大学：\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichType, "请问您想要浏览以下哪个类型的评论？\n" +
                "1)教授\n2)宿舍\n3)课程\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.UniNonExistent,"大学未找到，您想胃这所大学创建一个新的简介吗？\n" +
                "1)好啊\n2)算了吧\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.ProfNonExistent,"教授未找到，您想为这位教授创建一个新的简介吗？\n" +
                "1)好啊\n2)算了吧\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CourseNonExistent,"课程未找到，您是否要为本课程创建一个新的简介？\n" +
                "1)好啊\n2)算了吧\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.DormNonExistent,"宿舍未找到，您是否要为本宿舍创建一个新的简介\n" +
                "1)好啊\n2)算了吧\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskOverallRating, "请给这个评审对象一个1-5的总评分。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskForComment, "请给这个评审对象一段评语。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskProfName,"请输入被评审的教授的姓名。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskProfCourse,"对这次评审的教授，请输入这位教授教你的课程的课程代码。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskProfDifficulty, "以1-5的比例，请输入位教授课程的难度。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskProfClarity, "以1-5的比例，请输入这位教授的清晰度。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskProfEngagement, "以1-5的比例，请输入这位教授的参与程度。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskAttendance, "请输入此教授课程是否需要出席 (请只用 true 或者 false 回答)。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskTextbook, "请输入这位教授的课程是否需要课本 (请只用 true 或者 false 回答)。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskCourseCode,"请输入课程代码。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskCourseDifficulty, "以1-5的比例，请输入本课程的难度。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskWorkload, "在1-5的范围内，请输入本课程的工作量。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskParticipation, "请输入是否有必要参加本课程的课 (请只用 true 或者 false 回答)。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskTheoretical, "请输入本课程是否更偏理论性。(请只用 true 或者 false 回答)。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskApplied, "请输入此课程是否更偏应用(请只用 true 或者 false 回答)。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskInclusive, "请输入此课程是否包容所有人(请只用 true 或者 false 回答)。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskDormName, "请输入您想评审的宿舍的名字。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskCleanliness, "以1-5的比例，请输入本宿舍的清洁情况。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskSocialness, "以1-5的比例，请输入本宿舍的社交氛围。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskSoundproof, "以1-5的比例，请输入本宿舍的隔音质量。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskRA, "以1-5的比例，请输入您对本宿舍的住宿助理的评估。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskFood, "以1-5的比例，请评价本宿舍的食品质量。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskConvenience, "以1-5的比例，请评价本宿舍的便利性。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskWifi, "以1-5的比例，请评估这个宿舍的网络的速度。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskReviewID, "请输入您该评论的ID。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.AskReviewIDDenied, "你要么找的评论不存在，要么是别人的评论。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GiveReviewIDList, "以下是您可查阅的评论的清单:\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.IntegerOutOfRange, "输入值超出范围，请输入1-5之间的整数。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.NonBooleanMismatch, "输入值类型不匹配，请只用 true 或者 false 回答。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.ChangeNameSuccess, "用户名更改成功!\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.NewNameExists, "用户名更改失败，此用户名已经存在。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.ChangeEmailSuccess, "更改邮箱地址成功!\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.ChangeYearSuccess, "更改毕业年份成功!\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewName,"请输入您想更新的用户名：\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewYear,"请输入您想更新的毕业年份：\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewEmail,"请输入您想更新的学校邮箱地址：\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateDormName, "请输入您想创建的宿舍名称：\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateDormUni, "请输入此宿舍所属的大学：\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateDormFloor, "请输入此宿舍共有几层楼：\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateCourseCode, "请输入您想创建的课程代码：\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateCourseUni, "请输入该课程所属学校：\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateCourseDep, "请输入该课程所属院系：\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateProfDep, "请输入您想创建教授的所属院系：\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateProfUni, "请输入您想创建教授的所属大学：\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateProfName, "请输入您想创建教授的名字：\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.DisplayAllReviewIDs, "以下是所有可操作的评论ID: \n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewComment,"请输入更新的评论。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewOverallrating,"请输入更新的综合评级。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewProfName,"请输入更新的教授姓名。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewCouseName,"请输入更新的课程名称。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewDiffLvl,"请输入更新的课程难度级别。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewClarityLvl,"请输入最新的教授清晰度级别\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewEngLvl,"请输入更新的课堂互动级别\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewAttendance,"请输入最新的出席需求\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewTxtbook,"请输入更新的教科书必要性\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewCourseCode,"请输入更新的课程代码过程。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewWorkloadLvl,"请输入工作量的级别。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewTheo,"请输入有关该课程是否为理论课程的最新信息。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewApp,"请输入是否实用的更新信息。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewIncl,"请输入课程是否适合所有学生的最新信息。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewPart,"请输入更新的参加必要性\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewDormName,"请输入更新的宿舍名称。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewCleanLvl,"请输入最新的清洁级别。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewSocialLvl,"请输入更新的社交环境水平\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewSoundLvl,"请输入最新的防噪音等级.\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewRA,"请输入更新的RA等级。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewWifi,"请输入最新的WiFi速度级别。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewFood,"请输入食物的味道的更新水平。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.GetNewConven,"请输入更新的交通方便等级。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.CreateUniName, "请输入您要添加的大学名称。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.EmptyReviewLists, "目前我们暂无评论，请随意留言。\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.WhichCategory, "你想要查看以下的那一项: \n 1. 课程\n 2. 宿舍 \n 3. 教授:\n");
        mainPromptsMap.put(PromptDictionary.mainPrompts.HowToSortReviews, "您想要如何对评论进行排序: \n" +
                "1. 根据评论的总体评分 \n2. 根据评论的受欢迎程度\n") ;
    }
    private void initiateMenus() {
        MenusMap.put(PromptDictionary.Menu.MainMenu,"欢迎访问RateMyUni的主界面！请选择你想做的事:\n" +
                "1)浏览所有教授的简介\n" +
                "2)浏览所有课程的简介\n" +
                "3)浏览所有宿舍的简介\n" +
                "4)留下一个教授评论\n" +
                "5)留下一个课程评论\n" +
                "6)留下一个宿舍评论\n" +
                "7)浏览关于某个教授的所有评论\n" +
                "8)浏览关于某个课程的所有评论\n" +
                "9)浏览关于某个宿舍的所有评论\n" +
                "10)删除之前留下的评论\n" +
                "11)编辑先前留下的评论\n" +
                "12)查看您 Rate My Uni 的个人主页\n" +
                "13)编辑您 Rate My Uni 的个人主页\n" +
                "14)赞评论\n" +
                "15)投下评论\n" +
                "16)转到 RateMyUni 的用户选项菜单(比如查看用户登录历史等)\n" +
                "17)浏览 RateMyUni 系统中所有的大学\n" +
                "18)浏览某所大学的教授、课程或宿舍楼评分\n" +
                "19)将评论排序\n");
        MenusMap.put(PromptDictionary.Menu.UserOptionsMenu,"欢迎来到用户选项菜单。你现在可以\n" +
                "1) 查看历史。\n" +
                "2) 禁止非管理员用户（仅限管理员）\n" +
                "3) 使非管理员用户成为管理员（仅限管理员）\n" +
                "4) 删除非管理员用户（仅限管理员）\n" +
                "5) 返回 RateMyUni 的主菜单\n");
        MenusMap.put(PromptDictionary.Menu.EditProfileMenu, "请选择您想修改的选项:\n" +
                "1) 毕业年份r\n2) 电子邮箱地址\n3) 用户名\n4) 算啦，带我回到主界面\n");

        MenusMap.put(PromptDictionary.Menu.EditProfReviewMenu, "请选择要更新的教授评论项目:\n" +
                "1)课程名称\n" +
                "2)难度系数\n" +
                "3)清晰程度\n" +
                "4)互动程度\n" +
                "5)是否需要参与\n" +
                "6)是否想要课本\n" +
                "7)总评分\n" +
                "8)评语\n" +
                "9)回到主页\n");

        MenusMap.put(PromptDictionary.Menu.EditCourseReviewMenu, "请选择您想更新的课程评论项目:\n" +
                "1)难度系数\n" +
                "2)高质量\n" +
                "3)是否需要参与？\n" +
                "4)是否偏理论？\n" +
                "5)是否偏实用？\n" +
                "6)是否适合所有人？\n" +
                "7)总评分\n" +
                "8)评语 \n" +
                "9)回到主页\n");

        MenusMap.put(PromptDictionary.Menu.EditDormReviewMenu, "请选择您想更新的宿舍评论项目:\n" +
                "1)干净程度\n" +
                "2)社交环境\n" +
                "3)防噪音程度\n" +
                "4)宿管质量\n" +
                "5)食堂评价\n" +
                "6)方便程度\n" +
                "7)网速\n" +
                "8)总评分\n" +
                "9)评语 \n" +
                "10)回到主页\n");
    }
    private void initiateReviewPrompts() {
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.DeleteSuccess, "评论成功删除！\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.DeleteFailed, "您没有权限删除此评论或者该评论不存在。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.UpvoteSuccess, "成功赞评论！\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.UpvoteNonExistentReview, "投票失败是因为这个评论不存在。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.UpvoteExists, "投票失败，因为您已经投票了此评论。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.DownvoteSuccess, "成功降票评论！\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.DownvoteNonExistentReview, "降票失败，因为这个评论不存在。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.DownvoteExists, "降票失败，因为您已经降票了这篇评论。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.BrowseProfReview, ">>>以下是所有评论的教授:\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.BrowseCourseReview, ">>>以下是所有评论的课程:\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.BrowseDormReview, ">>>以下是所有评论的宿舍:\n");

        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeCommentSuccess, "成功更新此评论的评语。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeORSuccess, "成功更新了评论的总体评级。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeProfName, "成功地更新了教授的名子 \n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeCourseName, "成功更新了课程名称。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeDiffLvl, "成功地更新了难度级别。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeClarityLvl, "成功更新了清晰度级别。 \n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeEngLvl, "成功更新了参与度的需求。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeAttendance, "成功更新了是否需要出席。\n\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeTxtbook, "成功更新了教科书是否有必要。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeCourseCode, "成功更新了课程代码。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeWorkloadLvl, "成功更新了评审工作负载级别。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeIsTheo, "成功更新课程是否偏理论。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeIsApp, "成功更新课程是否偏实战。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeIsIncl, "成功更新课程是否适合所有人。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeIsPart, "成功更新参与是否必要。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeDormName, "成功更新了宿舍名称。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeCleanLvl, "成功更新清洁水平的评分。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeSocialLvl, "成功地更新了社交环境的评分。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeSoundLvl, "成功更新了对隔音的评分\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeRA, "成功地更新了宿管质量的评分\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeWifi, "成功更新了wifi的评分\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeFood, "成功更新了食物水平的评分。\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.ChangeConven, "成功更新了对方便程度的评分\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.EditReviewSuccess, "成功编辑评论！\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.EditReviewFailed, "编辑评论失败，您要么没有权限编辑此评论，要么审核不存在\n");


        reviewPromptsMap.put(PromptDictionary.reviewPrompts.BrowseUniversities, ">>>以下是此应用程序中所有大学的列表:\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.BrowseProfReviewInUni, ">>>以下是这所大学所有被评议过的教授名单:\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.BrowseDormReviewInUni, ">>>以下是这所大学所有被评议过的宿舍名单:\n");
        reviewPromptsMap.put(PromptDictionary.reviewPrompts.BrowseCourseReviewInUni, ">>>以下是本校所有被评议过课程名单:\n");
    }

    private void initiateUserOptionPrompts() {

        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.AskBanName, "请输入您想要禁止的非管理员用户的用户名。\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.AskBanTime, "请输入一个整数，您希望禁止这位用户多少小时\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.BanSuccess, "用户被成功禁用！\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.AlreadyBanned, "禁止无效，因为用户已经被禁止了\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.BanFailed, "禁止用户失败。 要么用户不存在，要么用户是管理员.\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.CreateAdminSuccess, "成功创建新管理员！\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.AskAdminName,"请输入您想要升级为非管理员的用户的用户名。\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.CreateAdminFailed, "此用户不存在，创建新管理员失败。\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.UserAlreadyAdmin, "这个用户已经是管理员了！\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.AskDeleteName,"请输入要删除的非管理员用户的用户名。\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.DeleteUserSuccess, "这个用户被成功删除！\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.DeleteUserFailed, "此用户不存在，删除用户失败。\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.DeleteAlreadyAdmin, "这个用户已经是管理员了。 您不能删除管理员。\n");
        userOptionPromptMap.put(PromptDictionary.userOptionPrompts.InvalidChoice, "很抱歉，此选项不可选！\n");
    }
}
