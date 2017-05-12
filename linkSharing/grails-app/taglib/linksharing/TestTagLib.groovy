//package linksharing
//
//class TestTagLib {
//    static defaultEncodeAs = [taglib:'html']
//    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
//
//
//
//    class ApplicationTagLib {
//        static defaultEncodeAs = [taglib: 'raw']
//        static namespace="ls"
//        //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]
//        def markAsRead={attrs->
//            User user=session.user
//            Resource resource=attrs?.resource
//            ReadingItem readingItem=ReadingItem.findByUserAndResource(user,resource)
//            if(readingItem&&readingItem.isRead){
//                out<<"<a href='javascript:void(0)' class='markasread' id='markasread-${resource.id}' data-url=${createLink(controller: 'readingItem',action: 'changeIsRead',params: [id:resource.id,isRead:false] )}>Mark as unread</a>"
//            }
//            else{
//                out<<"<a href='javascript:void(0)' class='markasread' id='markasread-${resource.id}' data-url=${createLink(controller: 'readingItem',action: 'changeIsRead',params: [id:resource.id,isRead:true])}>Mark as read</a>"
//            }
//        }
//        def trendingTopics={
//            User user=session.user
//            List<TopicVO> trendingTopics= Topic.getTrendingTopics()
//            out << g.render(template: "/topic/templates/trending", model: [trendingTopics: trendingTopics,user:user])
//        }
//        def topPost={
//            List<Resource> topPosts=Resource.getTopPosts(0,5)
//            out<<g.render(template: "/resource/templates/top-posts",model: [topPosts:topPosts,title:"Top Posts"])
//        }
//        def displayResource={attr->
//            Resource resource=attr?.resource
//            if(resource.isLinkResource()) {
//                out<<g.link(url: ((LinkResource)resource).url,"View full site")
//            }
//            else{
//                out<<g.link(url:g.createLink(controller: 'documentResource',action: 'download',id: resource.id),"Download")
//            }
//        }
//        def canDeleteResource={attr->
//            User user=session.user
//            Resource resource=attr?.resource
//            if(user.canDeleteRsourceOrTopic(resource)){
//
//            }
//            else{
//
//            }
//        }
//        def showSubscribe={attrs->
//            String output=""
//            User user=session.user
//            if(user&&attrs.topicId){
//                if(user.isSubscribed(attrs.topicId)){
//                    out<<"<a href='javascript:void(0)' class='subscription' id='subscription-${attrs.topicId}' data-url=${createLink(controller: "subscription",action: "delete",id: attrs.topicId)}>Unsubscribe</a>"
//                }
//                else{
//                    out<<"<a href='javascript:void(0)' class='subscription' id='subscription-${attrs.topicId}' data-url=${createLink(controller: "subscription",action: "save",id: attrs.topicId)}>Subscribe</a>"
//                }
//            }
//        }
//        def susbcriptionCount={attrs->
//            int count=0
//            String output=""
//            if(attrs.topicId){
//                Topic topic=Topic.get(attrs.topicId)
//                count=topic?.getSubscriptionCount()
//                output=g.link(controller: "topic",action: "show",params: [id:attrs.topicId],count.toString())
//            }
//            if(attrs.user){
//                User user=attrs.user
//                count=user.getUserSubscriptionsCount()
//                output=g.link(controller: "user",action: "profile",params: ["resourceSearchCO.id":user.id],count.toString())
//            }
//            out<<output
//        }
//        def resourceCount={attrs->
//            long topicId=0
//            int count=0
//            if(attrs.topicId){
//                topicId=attrs.topicId
//                Topic topic=Topic.get(topicId)
//                count=topic.getResourceCount()
//                out<<g.link(controller: "topic",action: "show",params: [id:attrs.topicId],count.toString())
//            }
//        }
//        def topicCount={attrs->
//            int count=0
//            if(attrs.user){
//                User user=attrs.user
//                count=user.getUserTopicsCount()
//                out<<g.link(controller: "user",action: "profile",params: ["resourceSearchCO.id":user.id],count.toString())
//            }
//        }
//        def userImage={attr->
//            if(attr.userId){
//                out << "<img src='${createLink(controller: "user", action: "image", id: "${attr.userId}")}' width=64 height=64 >"
//            }
//        }
//        def canUpdateTopic={attr->
//            User user=session.user
//            if(user){
//                def topic=attr?.topic
//                Subscription subscription=user.getSubscription(topic?.id)
//                if(subscription){
//                    if(topic.createdBy.equals(user)){
//                        out<<g.render(template: "/topic/templates/menuPanelForTopicCreator",model: [topic:topic])
//                    }
//                    else {
//                        out<<g.render(template: "/topic/templates/menuPanelForTopicSubscriber",model: [topic:topic])
//                    }
//                }
//            }
//        }
//        def showSeriousness={attr->
//            User user=session.user
//            def topic=attr?.topic
//            Subscription subscription=user.getSubscription(topic?.id)
//            if(subscription){
//                out<<g.render(template: "/topic/templates/subscription",model: [subscription:subscription])
//            }
//        }
//        def showEditTopic={attr->
//            def topic=attr?.topic
//            out<<g.render(template: "/topic/templates/editTopic",model: [topic: topic])
//        }
//        def showEditResource={attr->
//            def resource=attr?.resource
//            out<<g.render(template: "/resource/templates/editResource",model: [resource: resource])
//        }
//
//
//}
