<g:select name="seriousness" id="seriousness-${subscription.id}"
          from="${com.tothenew.linkshare.user.Seriousness.values()}"
          data-url="${g.createLink(controller: 'subscription', action: 'update')}" data-id="${subscription?.id}"
          value="${subscription?.seriousness}" class="form-control seriousness"/>